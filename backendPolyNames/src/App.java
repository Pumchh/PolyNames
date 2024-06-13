import controllers.CardsController;
import controllers.GameController;
import controllers.WordController;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Lancement programme");
        WebServer webServer = new WebServer();
        webServer.listen(8080);
        

        // Get all words from the database
        webServer.getRouter().get(
            "/get_allwords",
            (WebServerContext context) -> {WordController.findAll(context);}
            ); 

        // Get a word by its ID
        webServer.getRouter().get(
            "/getword/:card_ID",
            (WebServerContext context) -> {WordController.getWordById(context);}
            );

        // Put 25 cards in the table Cards
        webServer.getRouter().get(
            "/put_cards",
            (WebServerContext context) -> {CardsController.putCardsInTable(context, CardsController.pick25Cards(context));}
            );
        
        // Get the 25 cards from the table Cards
        webServer.getRouter().get(
            "/get_cards",
            (WebServerContext context) -> {CardsController.getSelectedCards(context);}
            );

        // Get the words from the table Cards
        webServer.getRouter().get(
            "/get_words",
            (WebServerContext context) -> {CardsController.getWords(context);}
            );

        // Create a game
        webServer.getRouter().get(
            "/create_game",
            (WebServerContext context) -> {GameController.createGame(context);}
        );

        // Get the game ID
        webServer.getRouter().get(
            "/get_gameID",
            (WebServerContext context) -> {GameController.getGameID(context);}
        );

        // Set the hintMaster name
        webServer.getRouter().get(
            "/set_hintMaster/:hintMaster",
            (WebServerContext context) -> {GameController.setHintMaster(context);}
        );

        // Set the wordMaster name
        webServer.getRouter().get(
            "/set_wordMaster/:wordMaster",
            (WebServerContext context) -> {GameController.setWordMaster(context);}
        );

        // Get the hintMaster name
        webServer.getRouter().get(
            "/get_hintMaster",
            (WebServerContext context) -> {GameController.getHintMaster(context);}
        );

        // Get the wordMaster name
        webServer.getRouter().get(
            "/get_wordMaster",
            (WebServerContext context) -> {GameController.getWordMaster(context);}
        );

        // Set the isRevealed value of a card to true by its ID
        webServer.getRouter().get(
            "/reveal/:card_ID",
            (WebServerContext context) -> {CardsController.reveal(context);}
        );

        // Get the isRevealed value of a card by its ID
        webServer.getRouter().get(
            "/get_isRevealed/:card_ID",
            (WebServerContext context) -> {CardsController.getIsRevealed(context);}
        );

    }
}
