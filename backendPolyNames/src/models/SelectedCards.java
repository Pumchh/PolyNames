package models;

public record SelectedCards(
    int id,
    String name,
    String color,
    boolean isKnown
) {}
