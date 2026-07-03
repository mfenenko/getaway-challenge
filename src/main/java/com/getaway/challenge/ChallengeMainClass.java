package com.getaway.challenge;

import java.util.stream.Stream;

import com.getaway.challenge.domain.Player;
import com.getaway.challenge.game.GameEngine;
import com.getaway.challenge.game.listener.GameCounter;
import com.getaway.challenge.game.rsp.RSPGame;
import com.getaway.challenge.game.rsp.RSPGameOptions;
import com.getaway.challenge.game.rsp.skill.RandomRSPGameSkill;
import com.getaway.challenge.game.rsp.skill.StaticRSPGameSkill;

/**
 * 
 */
public class ChallengeMainClass {

    public static final int DEFAULT_RUN_COUNT = 100;
    
    public static void main(String[] args) throws Exception {
        
        /*
         * 
         */
        Player player1 = new Player("1", "Mark");
            player1.addGameSkill(new RandomRSPGameSkill( Stream.of(RSPGameOptions.values()).toList() ));
        
        /*
         * 
         */
        Player player2 = new Player("2", "Olivia");
            player2.addGameSkill(new StaticRSPGameSkill(RSPGameOptions.ROCK));
        
        GameCounter gameCounter = new GameCounter();
        
        /*
         * Start game engine
         */
        try (GameEngine engine = new GameEngine()) {
        
            engine.addGameListener( new RSPGameResultPrinter() );
            engine.addGameListener( gameCounter );
            
            int loop = args.length > 0 ? Integer.parseInt( args[0] ) : DEFAULT_RUN_COUNT;
            
            for (int i = 0; i < loop; i++) {
                
                engine.submit(new RSPGame(i+1, player1, player2));
                
            }
        }
        
        /*
         * notify ended
         */
        System.out.println("""
            
        Total games RUN : %d
        """.formatted(gameCounter.getRunGamesCount()));
        
    }

}
