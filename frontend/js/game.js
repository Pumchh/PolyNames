function generateCards(){
    const grid = document.getElementById("grid");
    for(let i=0; i < 25; ++i){
        const newCard = document.createElement("card")
        //rajouter les prorpiétés deds cartes içi
        grid.appendChild(newCard)
    }
}



window.addEventListener("load", generateCards());