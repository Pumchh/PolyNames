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

    static async displayCards() {
        let list = await this.getCards()

        list.forEach(element => {
            console.log(element)
            document.querySelectorAll('card').innerHTML = element.word_ID;

        });

    }
}