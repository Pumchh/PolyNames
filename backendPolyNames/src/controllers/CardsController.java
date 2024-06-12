package controllers;

import java.util.ArrayList;

import dao.CardsDAO;
import models.Cards;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class CardsController {
    public static ArrayList<Cards> findAll(WebServerContext context) {
        ArrayList<Cards> cards = new ArrayList<Cards>();
        
        try{
            WebServerResponse response = context.getResponse();
            CardsDAO cardDAO = new CardsDAO();

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
            CardsDAO cardDAO = new CardsDAO();
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
