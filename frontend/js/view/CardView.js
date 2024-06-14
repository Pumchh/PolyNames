import { CardsService  } from "../services/CardServices.js";

export class CardsView{
    
async displayCards() {
    let stockage = await CardsService.getCards()
    //console.log(stockage)
    let i=0
    for(let bob in stockage){
        let result = stockage[bob]
        this.#displayCard(result)
    }

    let allCard = document.querySelectorAll('card')
    for(i;i<=allCard.length;i++){

        try {
            if( !(allCard[i] === undefined) ){
                let ID = allCard[i].getAttribute("word_ID")
                let word = await CardsService.getWord(ID);
                allCard[i].innerHTML = word;
            }
            
            
        } catch (error) {
            console.log("Error : "+ error)
        }
        
       

    }
    let data = await CardsService.getWords();
    //let list = JSON.parse(data)
    for(let i = 0; i<data.length;i++){
        this.#displayCard(data[i])
    }
}

#displayCard(_card){
    let allCard = document.querySelectorAll('card')
    let i=0;

    for(i;i<=allCard.length;i++){
        try {
            if( !(allCard[i] === undefined) ){
                if( !(allCard[i].hasAttribute("card_ID")) ){
                    let descriptors = Object.getOwnPropertyDescriptors(_card)
                    allCard[i].setAttribute("card_ID", descriptors.card_ID.value) 
                    allCard[i].setAttribute("game_ID", descriptors.game_ID.value) 
                    allCard[i].setAttribute("word_ID", descriptors.word_ID.value) 
                    allCard[i].setAttribute("color", descriptors.color.value) 
                    if(sessionStorage.getItem("Role_Choice") === "WordMaster"){
                        allCard[i].setAttribute("is_revealed", true) 
                    }
                    else {
                        allCard[i].setAttribute("is_revealed", descriptors.is_revealed.value)
                    }

        
                    //console.log( allCard[i])
                    break;
                }
            }
            
        } catch (error) {
            console.log("Error : " + error)
        }
       
        
    }

}

}




