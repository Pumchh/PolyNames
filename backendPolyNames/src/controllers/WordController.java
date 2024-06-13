package controllers;

import java.util.ArrayList;

import dao.WordsDAO;
import models.Words;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class WordController {
    public static ArrayList<Words> findAll(WebServerContext context) {
        ArrayList<Words> cards = new ArrayList<Words>();
        
        try{
            WebServerResponse response = context.getResponse();
            WordsDAO cardDAO = new WordsDAO();

            cards = cardDAO.findAll();

            response.json(cards);
            response.ok("Toutes les cartes");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public static String getWordById(WebServerContext context) {
        String word = "";
        try{
            WebServerResponse response = context.getResponse();
            WordsDAO cardDAO = new WordsDAO();
            String idTemp = context.getRequest().getParam("card_ID");
            int card_ID = Integer.parseInt(idTemp);

            word = cardDAO.getWordById(card_ID);

            response.json(word);
            response.ok("Mot trouvé");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return word;
    }

}
