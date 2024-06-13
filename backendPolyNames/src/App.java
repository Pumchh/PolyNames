import controllers.WordController;
import controllers.CardsController;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Lancement programme");
        WebServer webServer = new WebServer();
        webServer.listen(8080);

        webServer.getRouter().get(
            "/allcards",
            (WebServerContext context) -> {WordController.findAll(context);}
            ); 

        webServer.getRouter().get(
            "/getword/:card_ID",
            (WebServerContext context) -> {WordController.getWordById(context);}
            );

        webServer.getRouter().post(
            "/put_cards",
            (WebServerContext context) -> {CardsController.putCardsInTable(context, CardsController.pick25Cards(context));}
            );

        
        webServer.getRouter().get(
            "/get_selectedcards",
            (WebServerContext context) -> {CardsController.getSelectedCards(context);}
            );


        

        // webServer.getRouter().get(
        //     "/get_cards",
        //     (WebServerContext context) -> {CardsController.getSelectedCards(context);}
        // );

    }
}
