import controllers.CardsController;
import controllers.SelectedCardsController;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Lancement programme");
        WebServer webServer = new WebServer();
        webServer.listen(8080);

        webServer.getRouter().get(
            "/allcards",
            (WebServerContext context) -> {CardsController.findAll(context);}
            ); 

        webServer.getRouter().get(
            "/getword/:card_ID",
            (WebServerContext context) -> {CardsController.getWordById(context);}
            );

        webServer.getRouter().post(
            "/put_cards",
            (WebServerContext context) -> {SelectedCardsController.putCardsInTable(context, SelectedCardsController.pick25Cards(context));}
            );

        
        webServer.getRouter().get(
            "/get_selectedcards",
            (WebServerContext context) -> {SelectedCardsController.getSelectedCards(context);}
            );


        

        // webServer.getRouter().get(
        //     "/get_cards",
        //     (WebServerContext context) -> {CardsController.getSelectedCards(context);}
        // );

    }
}
