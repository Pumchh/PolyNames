package models;

public record Round(
    int round_ID,
    int game_ID,
    String hint,
    int guess_value,
    int round_score
){}
