package com.getaway.challenge.game.listener;

import java.util.concurrent.atomic.AtomicInteger;

import com.getaway.challenge.domain.AbstractGame;

/**
 * 
 */
public class GameCounter implements GameEngineListener {

    private AtomicInteger runCount = new AtomicInteger();

    @Override
    public void onFinished(AbstractGame game) {
        runCount.incrementAndGet();
    }
    
    /**
     * 
     */
    public int getRunGamesCount() {
        return runCount.get();
    }

}
