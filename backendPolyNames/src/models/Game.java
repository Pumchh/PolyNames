package models;


public record Game(
    String code,
    SelectedCards grid,
    Player player1,
    Player player2,
    int score
){}
