package controllers;

import dao.GameDAO;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class GameController {

    public static void createGame(WebServerContext context) {
        try{
            WebServerResponse response = context.getResponse();
            GameDAO gameDAO = new GameDAO();

            gameDAO.createGame();

            response.ok("Game created");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static int getGameID(WebServerContext context) {
        int game_ID = 0;
        try{
            WebServerResponse response = context.getResponse();
            GameDAO gameDAO = new GameDAO();

            game_ID = gameDAO.getGameID();

            response.json(game_ID);
            response.ok("Game ID found");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return game_ID;
    }
}
