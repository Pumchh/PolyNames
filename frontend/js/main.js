function setEventListener() {
    join_reference = document.getElementById("joinGame");
    join_reference.addEventListener("click", () => {getCode()});
    create_game = document.getElementById("createGame");
    create_game.addEventListener("click", () => { choice() });
}


function getCode() {
    code = document.getElementById("gameCode").value;
    answer = document.getElementById("answer");
    code = Number(code);
    console.log(code)

    if( isNaN(code) || (code === 0) ) {
        answer.innerHTML = "Code Invalide réessayez";
    }

    else {
        
        answer.innerHTML = "Code Bon";
    }

    
}

function choice(){

    corps = document.getElementById("BoxSpace")
    
    wordMasterBox = "<div class=\"Box\"><h1> Maître des mots </h1> <p> C'est celui qui sait et qui indique. Il a devant lui les cartes ainsi que leur couleur, il doit indiquer au Maître de l'intuition des indices permettant de choisir les bons mots </p> <button id=\"WMbutton\">Choisir</button></div>"
    
    hintMasterBox = "<div class=\"Box\"><h1> Maître des intuitions </h1> <p> C'est celui qui réfléchi et qui choisi. Il voit sans couleur et doit choisir les cartes correspondantes aux indices donnés par le Maître des mots. Attention aux cartes Rouges  <button id=\"HMbutton\">Choisir</button></p></div>"
    
    corps.innerHTML = wordMasterBox + hintMasterBox;

    document.getElementById("WMbutton").addEventListener("click", ()=>{WMchosen()})
    document.getElementById("HMbutton").addEventListener("click", ()=>{HMchosen()})
}

function WMchosen(){
    sessionStorage.setItem("Role_Choice","WordMaster")
    document.getElementById("HMbutton").disabled = true
}

function HMchosen(){
    sessionStorage.setItem("Role_Choice","HintMaster")
    document.getElementById("WMbutton").disabled = true
}












window.addEventListener("load", setEventListener())