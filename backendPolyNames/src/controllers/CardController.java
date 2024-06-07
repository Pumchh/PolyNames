package controllers;

import java.util.ArrayList;

import dao.CardDAO;
import models.Card;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class CardController {
    public static ArrayList<Card> findAll(WebServerContext context) {
        ArrayList<Card> cards = new ArrayList<Card>();
        
        try{
            WebServerResponse response = context.getResponse();
            CardDAO cardDAO = new CardDAO();

            cards = cardDAO.findAll();

            response.json(cards);
            response.ok("Toutes les cartes");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }



        return cards;
    }
}
