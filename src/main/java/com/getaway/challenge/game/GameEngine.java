package com.getaway.challenge.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.getaway.challenge.domain.AbstractGame;
import com.getaway.challenge.game.listener.GameEngineListener;

/**
 * 
 */
public class GameEngine implements AutoCloseable {

    private ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
    
    private Collection<GameEngineListener> listeners = new ArrayList<>();
    
    /**
     * 
     * @param game
     */
    public void submit(AbstractGame game) {
        
        executor.submit(() -> {
           
            while( !game.isFinished() ) {
               
                game.nextMove();
               
            }
           
            onFinished(game);
           
        });
    }

    /**
     * 
     * @param listener
     */
    public void addGameListener(GameEngineListener listener) {
        this.listeners.add(listener);
    }

    /*
     * 
     */
    protected final void onFinished(AbstractGame game) {
       this.listeners.forEach(l -> l.onFinished(game)); 
    }
    
    @Override
    public void close() throws Exception {
        executor.close();
    }
    
}
