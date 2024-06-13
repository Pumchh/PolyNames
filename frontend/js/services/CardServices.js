export class CardsService {

    static async selectCards() {
        const response = await fetch("http://localhost:8080/put_cards")
        
    }

    static async getCards() {
        const response = await fetch("http://localhost:8080/get_cards")
        if(response.status === 200){
            let data = await response.json()
            //console.log(data);
            return data;
        }
    }

    static async getWords(){
        const response = await fetch("http://localhost:8080/get_words") ;
        let data = await response.json()
        console.log(data)
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


