import { CardsService } from "./services/CardServices.js";
import { GameService } from "./services/GameService.js";
import { CardsView } from "./view/CardView.js";


async function gameCreation(){
    const game = await GameService.createGame();
    sessionStorage.gameID = await GameService.getGameID();
    await CardsService.selectCards();
    const view = new CardsView()
    await view.displayCards();
}

async function  actualizeCards(){
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
        await gameCreation();
        
    }
    if(sessionStorage.Role_Choice == "HintMaster"){
        const view = new CardsView()
        CardsService.getCards()
        await view.displayCards();

        let allCards = document.querySelectorAll('card')
        allCards.forEach((card) => {
            card.addEventListener("click", cardClicked())
        })
    }

}

async function cardClicked(){
    
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
