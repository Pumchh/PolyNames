package controllers;

import com.google.gson.JsonObject;

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

            JsonObject json = new JsonObject();
            json.addProperty("hintMaster", hintMaster);

            context.getSSE().emit("hintmaster", json);

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

            JsonObject json = new JsonObject();
            json.addProperty("wordMaster", wordMaster);

            context.getSSE().emit("wordmaster", json);

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

    public static void setScore(WebServerContext context) {
        try{
            WebServerResponse response = context.getResponse();
            GameDAO gameDAO = new GameDAO();
            int score = Integer.parseInt(context.getRequest().getParam("score"));

            gameDAO.setScore(score);
            context.getSSE().emit("score", score);

            response.ok("Score set");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static int getScore(WebServerContext context) {
        int score = 0;
        try{
            WebServerResponse response = context.getResponse();
            GameDAO gameDAO = new GameDAO();
            int game_ID = Integer.parseInt(context.getRequest().getParam("game_ID"));

            score = gameDAO.getScore(game_ID);

            response.json(score);
            response.ok("Score found");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return score;
    }

}
