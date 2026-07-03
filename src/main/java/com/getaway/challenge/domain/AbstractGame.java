package com.getaway.challenge.domain;

public abstract class AbstractGame {

    protected String gameId;
    
    protected AbstractGame(String gameId) {
        this.gameId = gameId;
    }
    
    public String getGameId() {
        return gameId;
    }
    
    public abstract void nextMove();
    
    public abstract boolean isFinished();
    
}
