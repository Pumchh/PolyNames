package models;

public record Cards(
    int card_ID,
    int game_ID,
    int word_ID,
    String color,
    boolean is_revealed
) {}
