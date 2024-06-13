import { CardsService  } from "../services/CardServices.js";

export class CardsView{
    
async displayCards() {
    let stockage = await CardsService.getCards()
    let arrayOfCard = []
    console.log(stockage)
    let i=0
    for(let bob in stockage){
        let result = stockage[bob]
        this.#displayCard
    }

    let allCard = document.querySelectorAll('card')
  
    sessionStorage.grid = stockage
    let data = await CardsService.getWords();
    //let list = JSON.parse(data)
    for(let i = 0; i<data.length;i++){
        this.#displayCard(data[i])
    }
}

async #displayCard(_card){
    let allCard = document.querySelectorAll('card')
    //console.log(_word)
    let i=0;
    for(i;i<=allCard.length;i++){
        if(allCard[i].cardObject === undefined ){
            
            allCard[i].cardObject = _card;
        }
    }

}

}




