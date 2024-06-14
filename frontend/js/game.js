import { CardsService } from "./services/CardServices.js";
import { GameService } from "./services/GameService.js";
import { CardsView } from "./view/CardView.js";




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
        scoreBox.innerHTML = "<center> <h3> Donnez un indice </h3> <input id=\"inputIndice\"></input> <button id=\"seHint\"> Evoyer l'indice </button> </center>";
        document.getElementById("seHint").addEventListener("click", ()=>{sendHint()})
        sessionStorage.setItem("score",0)
    }
    if(sessionStorage.Role_Choice == "HintMaster"){
        let allCards = document.querySelectorAll('card')
        allCards.forEach((card) => {
            card.addEventListener("click", () => {cardClicked(card)})
        })
        let send_button = document.getElementById("validate_sel")
        send_button.addEventListener("click" , ()=>{sel_send()} )
        sessionStorage.setItem("score",0)
    }

}

async function sel_send() {
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
 
    //gestion du score à finir !!!
    console.log(selCards)
    for(let k in selCards){
        
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
    }
    actualizeCards()
    

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


function sendHint(){
    console.log("click")
    // envoyer l'indice
    let hist = document.getElementById("history");
    let toAdd = document.createElement("p");
    toAdd.innerHTML = "Indice envoyé";
    hist.insertBefore(toAdd,hist.firstChild);

}



document.getElementById("RoleDisplay").innerHTML = document.getElementById("RoleDisplay").innerHTML + sessionStorage.Role_Choice;
window.addEventListener("load", generateCards());
window.addEventListener("load", displayRightHTML());
window.addEventListener("load", actualizeCards());

document.querySelector('card').classList.contains