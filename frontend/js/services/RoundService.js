export class RoundService {

    static async createRound() {
        const response = await fetch("http://localhost:8080/create_round")
        if(response.status === 200){
            console.log("Round Created")
        }
    }
    
    
    static async getRoundID() {
        const response = await fetch("http://localhost:8080/get_roundID")
        if(response.status === 200){
            let data = await response.json()
            //console.log(data);
            return data;
        }
    }

    static async setScore(_game_ID){
        const response = await fetch("http://localhost:8080/set_score/"+_game_ID)
    }

}