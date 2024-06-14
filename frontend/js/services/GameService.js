export class GameService {

    static async createGame() {
        const response = await fetch("http://localhost:8080/game/create_game")
        if(response.status === 200){
            //console.log("partie Créée")
        }
    }
    
    
    static async getGameID() {
        const response = await fetch("http://localhost:8080/game/get_gameID")
        if(response.status === 200){
            let data = await response.json()
            //console.log(data);
            return data;
        }
    }

    static async setScore(_score){
        const response = await fetch("http://localhost:8080/game/set_score/"+_score)
    }

    static async sendHint(_hint){
        const response = await fetch("http://localhost:8080/game/set_hint/"+_hint)
 
    }

    static async getHint(){
        const response = await fetch("http://localhost:8080/game/get_hint")
        if(response.status === 200){
            let data = await response.json()
            //console.log(data);
            return data;
        }
    }


    static async updateHint(){
        let guessValue = await get // to finish
        let hint = await this.getHint();
        let hist = document.getElementById("history");
        let toAdd = document.createElement("p");
        toAdd.innerHTML = "Indice \" " + hint + "\" envoyé";
        hist.insertBefore(toAdd,hist.firstChild);
    }
}

