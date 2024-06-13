export class CardsService {

    static async generateCards() {
        const response = await post("http://localhost:8080/put_cards")
        
    }
}