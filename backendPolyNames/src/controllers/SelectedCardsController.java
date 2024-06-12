package controllers;

import java.util.ArrayList;


import dao.SelectedCardsDAO;
import models.SelectedCards;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class SelectedCardsController {
        public static ArrayList<SelectedCards> pick25Cards(WebServerContext context){
        ArrayList<SelectedCards> cards = new ArrayList<SelectedCards>();

        try{
            WebServerResponse response = context.getResponse();
            SelectedCardsDAO selectedCardsDAO = new SelectedCardsDAO();

            cards = selectedCardsDAO.pick25Cards();

            response.json(cards);
            response.ok("25 cards selected");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public static void putCardsInTable(WebServerContext context, ArrayList<SelectedCards> cards){
        try{
            
            WebServerResponse response = context.getResponse();
            SelectedCardsDAO cardDAO = new SelectedCardsDAO();

            cardDAO.putCardsInTable(cards);

            response.ok("25 cards added to the table");

            System.out.println("25 cards added to the table");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<SelectedCards> getSelectedCards(WebServerContext context){
        ArrayList<SelectedCards> cards = new ArrayList<SelectedCards>();

        try{
            WebServerResponse response = context.getResponse();
            SelectedCardsDAO selectedCardsDAO = new SelectedCardsDAO();

            cards = selectedCardsDAO.getSelectedCards();

            response.json(cards);
            response.ok("Get cards selected");

            System.out.println("Get cards selected");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public static ArrayList<String> getWordsByIds(WebServerContext context, ArrayList<Integer> ids){
        ArrayList<String> words = new ArrayList<String>();

        try{
            WebServerResponse response = context.getResponse();
            SelectedCardsDAO selectedCardsDAO = new SelectedCardsDAO();

            for(int id : ids){
                words.add(selectedCardsDAO.getWordById(id));
            }

            response.json(words);
            response.ok("Get words selected");

            System.out.println("Get words selected");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return words;
    }

}
