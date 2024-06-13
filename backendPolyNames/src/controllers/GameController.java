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

    public static void setHintMaster(WebServerContext context) {
        try{
            WebServerResponse response = context.getResponse();
            GameDAO gameDAO = new GameDAO();
            String hintMaster = context.getRequest().getParam("hintMaster");

            gameDAO.setHintMaster(hintMaster);

            response.ok("HintMaster set");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static void setWordMaster(WebServerContext context) {
        try{
            WebServerResponse response = context.getResponse();
            GameDAO gameDAO = new GameDAO();
            String wordMaster = context.getRequest().getParam("wordMaster");

            gameDAO.setWordMaster(wordMaster);

            response.ok("WordMaster set");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static String getHintMaster(WebServerContext context) {
        String hintMaster = "";
        try{
            WebServerResponse response = context.getResponse();
            GameDAO gameDAO = new GameDAO();

            hintMaster = gameDAO.getHintMaster();

            response.json(hintMaster);
            response.ok("HintMaster found");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return hintMaster;
    }

    public static String getWordMaster(WebServerContext context) {
        String wordMaster = "";
        try{
            WebServerResponse response = context.getResponse();
            GameDAO gameDAO = new GameDAO();

            wordMaster = gameDAO.getWordMaster();

            response.json(wordMaster);
            response.ok("WordMaster found");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return wordMaster;
    }

}
