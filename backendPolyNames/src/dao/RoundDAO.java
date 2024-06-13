package dao;

import java.sql.PreparedStatement;

import database.PolyNamesDatabase;

public class RoundDAO {

    public RoundDAO() {

    }

    public void createRound() {
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "INSERT INTO rounds (round_ID) VALUES (DEFAULT);";

            PreparedStatement statement = database.prepareStatement(request);
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
