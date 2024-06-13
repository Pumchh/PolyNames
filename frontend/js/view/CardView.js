import { CardsService  } from "../services/CardServices.js";

export class CardsView{
    
async displayCards() {
    let data = await CardsService.getWords();
    //let list = JSON.parse(data)
    for(let i = 0; i<data.length;i++){
        this.#displayCard(data[i])
    }
}

#displayCard(_word){
    let allCard = document.querySelectorAll('card')
    console.log(_word)
    let i=0;
    for(i;i<=allCard.length;i++){
        if(allCard[i].innerHTML === ""){
            
            allCard[i].innerHTML = _word;
            break;
        }
    }
}

}




