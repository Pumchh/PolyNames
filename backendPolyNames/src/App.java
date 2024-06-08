import controllers.CardController;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Lancement programme");
        WebServer webServer = new WebServer();
        webServer.listen(8080);

        webServer.getRouter().get(
            "/allcards",
            (WebServerContext context) -> {CardController.findAll(context);}
            ); 

        webServer.getRouter().get(
            "/select_cards",
            (WebServerContext context) -> {CardController.chooseCards(context);}
            );

        webServer.getRouter().post(
            "/put_cards",
            (WebServerContext context) -> {CardController.putChooseCardsInTable(context, CardController.chooseCards(context));}
            );

    }
}
