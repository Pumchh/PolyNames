package models;


public record Game(
    int code,
    Player hintMaster,
    Player wordMaster,
    int score
){}
