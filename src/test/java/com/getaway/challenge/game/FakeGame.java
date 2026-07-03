package com.getaway.challenge.game;

import com.getaway.challenge.domain.AbstractGame;

public class FakeGame extends AbstractGame {

    public FakeGame() {
        super("fake-0");
    }
    
    @Override
    public void nextMove() {
        // do nothing
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
