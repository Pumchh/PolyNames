import { GameService } from "./services/GameService.js";
import { CardsService } from "./services/CardServices.js";
import { RoundService } from "./services/RoundService.js";


function setEventListener() {
    let join_reference = document.getElementById("joinGame");
    join_reference.addEventListener("click", () => {getCode()});
    let create_game = document.getElementById("createGame");
    create_game.addEventListener("click", async () => { 
        await gameCreation()
        choice() });
}


function getCode() {
    let code = document.getElementById("gameCode").value;
    let answer = document.getElementById("answer");
    code = Number(code);
    console.log(code)

    if( isNaN(code) || (code === 0) ) {
        answer.innerHTML = "Code Invalide réessayez";
    }

    else {
        
        answer.innerHTML = "Code Bon";
        sessionStorage.setItem("gameID", code )
        choice()
    }

    
}

function choice(){
    sessionStorage.setItem("Name",document.getElementById("userName").value)
    
    let corps = document.getElementById("BoxSpace")
    let wordMasterBox = "<div class=\"Box\"><h1> Maître des mots </h1> <p> C'est celui qui sait et qui indique. Il a devant lui les cartes ainsi que leur couleur, il doit indiquer au Maître de l'intuition des indices permettant de choisir les bons mots </p> <button id=\"WMbutton\">Choisir</button></div>"
    
    let hintMasterBox = "<div class=\"Box\"><h1> Maître des intuitions </h1> <p> C'est celui qui réfléchi et qui choisi. Il voit sans couleur et doit choisir les cartes correspondantes aux indices donnés par le Maître des mots. Attention aux cartes Rouges  <button id=\"HMbutton\">Choisir</button></p></div>"
    
    corps.innerHTML = wordMasterBox + hintMasterBox;

    document.getElementById("WMbutton").addEventListener("click", ()=>{WMchosen()})
    document.getElementById("HMbutton").addEventListener("click", ()=>{HMchosen()})
}

async function WMchosen(){
    sessionStorage.setItem("Role_Choice","WordMaster")
    document.getElementById("HMbutton").disabled = true
    window.location.href = "GameWindow.html"
    
    
}

function HMchosen(){
    sessionStorage.setItem("Role_Choice","HintMaster")
    document.getElementById("WMbutton").disabled = true
    window.location.href = "GameWindow.html"

    
}

async function gameCreation(){
    const game = await GameService.createGame();
    sessionStorage.gameID = await GameService.getGameID();
    await CardsService.pu
    await CardsService.selectCards();
    let gameID = await GameService.getGameID()
    sessionStorage.setItem("gameID", gameID)
    //await RoundService.createRound()
    
}





window.addEventListener("load", setEventListener())