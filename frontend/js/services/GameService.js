export class GameService {

    static async createGame() {
        const response = await fetch("http://localhost:8080/game/create_game")
        if(response.status === 200){
            //console.log("partie Créée")
        }
    }
    
    
    static async getGameID() {
        const response = await fetch("http://localhost:8080/get_gameID")
        if(response.status === 200){
            let data = await response.json()
            //console.log(data);
            return data;
        }
    }

    static async setScore(_score){
        const response = await fetch("http://localhost:8080/set_game_score/"+_score)
    }

    static async sendHint(_hint){
        const response = await fetch("http://localhost:8080/set_hint/"+_hint)
 
    }
    static async sendGuessValue(_guessValue){
        const response = await fetch("http://localhost:8080/set_guessValue/"+_guessValue)
    }

    static async getHint(){
        const response = await fetch("http://localhost:8080/get_hint")
        if(response.status === 200){
            let data = await response.json()
            //console.log(data);
            return data;
        }
    }
    static async getGuessValue(){
        const response = await fetch("http://localhost:8080/get_guessValue")
        if(response.status === 200){
            let data = await response.json()
            //console.log(data);
            return data;
        }
    }

    static async getScore(){
        const response = await fetch("http://localhost:8080/get_game_score/"+sessionStorage.getItem("gameID"))
        if(response.status === 200){
            let data = await response.json()
            //console.log(data);
            return data;
        }
    }


    static async updateHint(){
        let guessValue = await this.getGuessValue()
        let hint = await this.getHint();
        let hist = document.getElementById("history");
        let toAdd = document.createElement("p");
        toAdd.innerHTML = "Indice \" " + hint + " - " + guessValue + "\" envoyé";
        hist.insertBefore(toAdd,hist.firstChild);
    }

    static async updateScore(){
        let score = await this.getScore()
        sessionStorage.setItem("score", score)
    }
}

