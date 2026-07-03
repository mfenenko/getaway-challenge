package com.getaway.challenge.game;

import org.junit.jupiter.api.Test;

import com.getaway.challenge.game.listener.GameCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 
 */
public class GameEngineTest {

    @Test
    public void noGamesEngineTest() throws Exception {
        
        GameCounter gameCounter = new GameCounter();
        try (GameEngine engine = new GameEngine() ) {
            
            engine.addGameListener(gameCounter);
            
            engine.submit(null);
                                    
        }
        
        assertEquals(0, gameCounter.getRunGamesCount());
    }
    
    @Test
    public void fakeGameEngineTest() throws Exception {

        GameCounter gameCounter = new GameCounter();

        try (GameEngine engine = new GameEngine() ) {

            engine.addGameListener(gameCounter);

            engine.submit(new FakeGame());
            
        }
        
        assertEquals(1, gameCounter.getRunGamesCount());
    }

    
    @Test
    public void severalGameEngineTest() throws Exception {

        GameCounter gameCounter = new GameCounter();

        try (GameEngine engine = new GameEngine() ) {

            engine.addGameListener(gameCounter);

            engine.submit(new FakeGame());
            engine.submit(null);
            engine.submit(new FakeGame());
            
        }
        
        assertEquals(2, gameCounter.getRunGamesCount());
    }

}
