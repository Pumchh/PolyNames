package models;

public record SelectedCards(
    int id,
    int card_ID,
    String color,
    boolean is_revealed
) {}
