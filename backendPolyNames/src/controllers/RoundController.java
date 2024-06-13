package controllers;

import dao.RoundDAO;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class RoundController {

    public static void createRound(WebServerContext context) {

        try{
            WebServerResponse response = context.getResponse();
            RoundDAO roundDAO = new RoundDAO();

            roundDAO.createRound();

            response.ok("Round créé");
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static void getRoundID(WebServerContext context) {

        try{
            WebServerResponse response = context.getResponse();
            RoundDAO roundDAO = new RoundDAO();

            int round_ID = roundDAO.getRoundID();

            response.json(round_ID);
            response.ok("Round_ID récupéré");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static void setHint(WebServerContext context) {

        try{
            WebServerResponse response = context.getResponse();
            RoundDAO roundDAO = new RoundDAO();

            String hint = context.getRequest().getParam(":value");

            roundDAO.setHint(hint);

            response.ok("Hint ajouté");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }


    public static void setGuessValue(WebServerContext context) {

        try{
            WebServerResponse response = context.getResponse();
            RoundDAO roundDAO = new RoundDAO();

            String guessValueTemp = context.getRequest().getParam(":round_ID");
            int guessValue = Integer.parseInt(guessValueTemp);

            roundDAO.setGuessValue(guessValue);

            response.ok("GuessValue ajouté");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static void setRoundScore(WebServerContext context) {

        try{
            WebServerResponse response = context.getResponse();
            RoundDAO roundDAO = new RoundDAO();

            String roundScoreTemp = context.getRequest().getParam(":round_ID");
            int roundScore = Integer.parseInt(roundScoreTemp);

            roundDAO.setRoundScore(roundScore);

            response.ok("RoundScore ajouté");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static String getHint(WebServerContext context) {
        String hint = "";
        try{
            WebServerResponse response = context.getResponse();
            RoundDAO roundDAO = new RoundDAO();

            hint = roundDAO.getHint();

            response.json(hint);
            response.ok("Hint récupéré");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return hint;
    }

    public static String getHintRound(WebServerContext context) {
        String hint = "";
        try{
            WebServerResponse response = context.getResponse();
            RoundDAO roundDAO = new RoundDAO();

            String roundScoreTemp = context.getRequest().getParam(":round_ID");
            int round_ID = Integer.parseInt(roundScoreTemp);

            hint = roundDAO.getHint(round_ID);

            response.json(hint);
            response.ok("Hint récupéré");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return hint;
    }



    public static int getGuessValueRound(WebServerContext context) {
        int guessValue = 0;
        try{
            WebServerResponse response = context.getResponse();
            RoundDAO roundDAO = new RoundDAO();

            String roundScoreTemp = context.getRequest().getParam(":round_ID");
            int round_ID = Integer.parseInt(roundScoreTemp);

            guessValue = roundDAO.getGuessValue(round_ID);

            response.json(guessValue);
            response.ok("GuessValue récupéré");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return guessValue;
    }

    public static int getRoundScore(WebServerContext context) {
        int roundScore = 0;
        try{
            WebServerResponse response = context.getResponse();
            RoundDAO roundDAO = new RoundDAO();

            roundScore = roundDAO.getRoundScore();

            response.json(roundScore);
            response.ok("RoundScore récupéré");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return roundScore;
    }

    public static int getRoundScoreRound(WebServerContext context) {
        int roundScore = 0;
        try{
            WebServerResponse response = context.getResponse();
            RoundDAO roundDAO = new RoundDAO();

            String roundScoreTemp = context.getRequest().getParam(":round_ID");
            int round_ID = Integer.parseInt(roundScoreTemp);

            roundScore = roundDAO.getRoundScore(round_ID);

            response.json(roundScore);
            response.ok("RoundScore récupéré");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return roundScore;
    }

    
    

}
