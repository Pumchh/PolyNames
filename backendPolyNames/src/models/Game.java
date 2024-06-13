package models;


public record Game(
    int session_code,
    String hintMaster,
    String wordMaster,
    int score
){}
