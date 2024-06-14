export class CardsService {

    static async selectCards() {
        const response = await fetch("http://localhost:8080/game/put_cards")
        
    }

    static async getCards() {
        const response = await fetch("http://localhost:8080/game/get_cards")
        if(response.status === 200){
            let data = await response.json()
            //console.log(data);
            return data;
        }
    }

    static async getWords(){
        const response = await fetch("http://localhost:8080/cards/get_words") ;
        let data = await response.json()
        //console.log(data)
        return data;
    }

    static async revealCard(_id){
        const response = await fetch("http://localhost:8080/cards/reveal/" + _id) ;
    
    }

    static async isRevealed(_id){
        const response = await fetch("http://localhost:8080/get_isRevealed/:card_ID")
        let data = await response.json()
        return data;
    }

    static async getWord(_id){
        const response = await fetch("http://localhost:8080/getword/"+ _id )
        if(response.status === 200){
            let data = await response.json()
            //console.log(data);
            return data;
        }
    }
    

}


