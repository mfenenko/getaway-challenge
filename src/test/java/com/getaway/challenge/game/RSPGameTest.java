package com.getaway.challenge.game;

import org.junit.jupiter.api.Test;

import com.getaway.challenge.domain.Player;
import com.getaway.challenge.game.rsp.RSPGame;
import com.getaway.challenge.game.rsp.RSPGameOptions;
import com.getaway.challenge.game.rsp.skill.StaticRSPGameSkill;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 
 */
public class RSPGameTest {

    @Test
    public void noPlayerRSPGameTest() throws Exception {
        
        assertThrows(AssertionError.class, () -> {
            
            new RSPGame(0, null, null);
        
        });
        
    }
    
    @Test
    public void noPlayerSkillRSPGameTest() throws Exception {
        
        assertThrows(AssertionError.class, () -> {
            
            new RSPGame(0, new Player("0", "Mark"), new Player("1", "Olivia"));
            
        });
        
    }
    
    @Test
    public void basePlayerWithStaticSkillsRSPGameTest() throws Exception {
        
        Player player1 = new Player("1", "Mark");
            player1.addGameSkill(new StaticRSPGameSkill(RSPGameOptions.SCISSORS));
            
        Player player2 = new Player("2", "Olivia");
            player2.addGameSkill(new StaticRSPGameSkill(RSPGameOptions.ROCK));

        //
        RSPGame game = new RSPGame(1, player1, player2);

        try (GameEngine engine = new GameEngine()) {
        
            engine.submit(game);
                
        }
        
        assertEquals(player2, game.getWinner() );
        assertEquals(player1, game.getLooser() );
    }
    
}
