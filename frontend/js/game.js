function generateCards(){
    const grid = document.getElementById("grid");
    for(let i=0; i < 25; ++i){
        const newCard = document.createElement("card")
        
        //rajouter les prorpiétés des cartes içi
        grid.appendChild(newCard)
        grid.removeC
    }
}

function displayRightHTML(){
    if(sessionStorage.Role_Choice == "WordMaster"){
        scoreBox = document.getElementById("score-box");
        scoreBox.innerHTML = "<center> <h3> Donnez un indice </h3> <input id=\"inputIndice\"></input> <button id=\"seHint\"> Evoyer l'indice </button> </center>";
        document.getElementById("seHint").addEventListener("click", ()=>{sendHint()})
        
    
    }

}

function sendHint(){
    console.log("click")
    // envoyer l'indice
    hist = document.getElementById("history");
    toAdd = document.createElement("p");
    toAdd.innerHTML = "Indice envoyé";
    hist.insertBefore(toAdd,hist.firstChild);
}



document.getElementById("RoleDisplay").innerHTML = document.getElementById("RoleDisplay").innerHTML + sessionStorage.Role_Choice;


window.addEventListener("load", displayRightHTML());
window.addEventListener("load", generateCards());