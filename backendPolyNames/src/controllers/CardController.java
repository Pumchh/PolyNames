package controllers;

import java.util.ArrayList;

import dao.CardDAO;
import models.Card;
import models.SelectedCards;
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

    public static ArrayList<SelectedCards> chooseCards(WebServerContext context){
        ArrayList<SelectedCards> cards = new ArrayList<SelectedCards>();

        try{
            WebServerResponse response = context.getResponse();
            CardDAO cardDAO = new CardDAO();

            cards = cardDAO.chooseCards();

            response.json(cards);
            response.ok("25 cartes choisies");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public static void putChooseCardsInTable(WebServerContext context, ArrayList<SelectedCards> cards){
        try{
            
            WebServerResponse response = context.getResponse();
            CardDAO cardDAO = new CardDAO();

            cardDAO.putChooseCardsInTable(cards);

            response.ok("25 cartes choisies et ajoutées à la table");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

}
