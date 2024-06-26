import { CardsService } from "./services/CardServices.js";
import { GameService } from "./services/GameService.js";
import { CardsView } from "./view/CardView.js";
import { SSEClient } from "../libs/sse-client.js";
import { RoundService } from "./services/RoundService.js";



async function actualizeCards(){
    const view = new CardsView()
    await view.displayCards();
}

function generateCards(){
    const grid = document.getElementById("grid");
    for(let i=0; i < 25; ++i){
        const newCard = document.createElement("card")
        
        grid.appendChild(newCard)
    }
}

async function displayRightHTML(){
    if(sessionStorage.Role_Choice == "WordMaster"){
        let scoreBox = document.getElementById("score-box");
        scoreBox.innerHTML = "<center><h3> Score : </h3><p id=\"score-counter\">0</p> <h3> Donnez un indice et le nombre de mots auquel il correspond </h3> <input id=\"inputIndice\"></input> <input id=\"inputGuessValue\"> </input> <br> <button id=\"seHint\"> Evoyer l'indice </button> </center>";
        document.getElementById("seHint").addEventListener("click", ()=>{sendHint()})
        sessionStorage.setItem("score",0)
    }
    if(sessionStorage.Role_Choice == "HintMaster"){
        let allCards = document.querySelectorAll('card')
        allCards.forEach((card) => {
            card.addEventListener("click", () => {cardClicked(card)})
            if(sessionStorage.getItem("Role_Choice") === "WordMaster"){
                card.classList.add("revealed")
            }
        })
        let send_button = document.getElementById("validate_sel")
        send_button.addEventListener("click" , ()=>{selection_send()} )
        sessionStorage.setItem("score",0)
    }

}

async function selection_send() {
    let allCards = document.querySelectorAll("card")
    let j = 0 ;
    let selCards = []
    for(let i in allCards){
        try {
            if( !(allCards[i].classList === undefined) ){
                
                if(allCards[i].classList.contains("selected")) {

                    CardsService.revealCard(allCards[i].card_ID)
                    allCards[i].classList.remove("selected")
                    allCards[i].classList.add("revealed")
                    allCards[i].setAttribute("is_revealed", true)
                    selCards[j] = allCards[i];
                    j++
                }
            }
        } catch (error) {
            console.log("Error : " + error)
        }
    }

    for(let k in selCards){ // gestion score en fonction sélection
        
            if(selCards[k].getAttribute("color") === "blue"){
           
                if(selCards[parseInt(k)+1] === undefined){
                    let toAdd = parseInt(k)+1;
                    let current_score = parseInt(sessionStorage.getItem("score"))
                    sessionStorage.setItem("score", current_score + toAdd*toAdd );
                }
                else {
                    let toAdd = parseInt(k)+1;
                    let current_score = parseInt(sessionStorage.getItem("score"))
                    sessionStorage.setItem("score", current_score + toAdd );
                   
                }
            }
            else if(selCards[k].getAttribute("color") === "black"){
                window.close;
            }        
    }

    let hint = await GameService.getHint()
    let guessValue = await GameService.getGuessValue()
    let hist = document.getElementById("history");
    let toAdd = document.createElement("p");
    toAdd.innerHTML = "Indice \" " + hint + " - " + guessValue + "\" envoyé";
    hist.insertBefore(toAdd,hist.firstChild);
    
    let scoreCase = document.getElementById("score-counter")
    scoreCase.innerHTML = sessionStorage.getItem("score")
    GameService.setScore(sessionStorage.getItem("score"))

    await actualizeCards()

}

async function cardClicked(_card){
    if( !(_card.classList.contains("revealed")) ) {
        if( !(_card.classList.contains("selected")) ){
            _card.classList.add("selected")
        }
        else if(_card.classList.contains("selected")){
            _card.classList.remove("selected")
        }
    }

}


async function sendHint(){
    //console.log("click")
    let guessValue = document.getElementById("inputGuessValue").value
    let hint = document.getElementById("inputIndice").value
    let hist = document.getElementById("history");
    let toAdd = document.createElement("p");
    toAdd.innerHTML = "Indice \" " + hint + " - " + guessValue +"\" envoyé";
    hist.insertBefore(toAdd,hist.firstChild);
    awaitGameService.sendHint(hint)
    awaitGameService.sendGuessValue(guessValue)
    await GameService.updateScore()

}

//const mySSEClient = new SSEClient("localhost:8080"); 
//await mySSEClient.connect();
//await mySSEClient.subscribe("hint" ,await GameService.updateHint() )
//gitawait mySSEClient.subscribe("score", await GameService.updateScore() )



document.getElementById("RoleDisplay").innerHTML = document.getElementById("RoleDisplay").innerHTML + sessionStorage.Role_Choice;
window.addEventListener("load", generateCards());
window.addEventListener("load", displayRightHTML());
window.addEventListener("load", actualizeCards());

document.querySelector('card').classList.contains