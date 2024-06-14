import { GameService } from "../services/GameService.js";

export class GameView {

    static addWordMaster(_wordMaster) {
        GameService.setWordMaster(_wordMaster);
    }

    static addHintMaster(_hintMaster) {
        GameService.setHintMaster(_hintMaster);
    }

    static async getGameID() {
        await GameService.getGameID();
    }

    async createGame() {
        await GameService.createGame();
    }

}