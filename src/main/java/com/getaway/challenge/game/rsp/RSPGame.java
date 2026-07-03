package com.getaway.challenge.game.rsp;

import java.util.ArrayList;
import java.util.Collection;

import com.getaway.challenge.domain.Player;
import com.getaway.challenge.domain.AbstractGame;
import com.getaway.challenge.game.rsp.skill.RSPGameSkill;

import static com.getaway.challenge.game.rsp.RSPGameOptions.*;

/**
 * Class that represents Rock-Scissors-Paper game
 */
public class RSPGame extends AbstractGame {

    // participans
    private Player player1;
    private Player player2;
    
    private boolean isFinished = false;
    
    // results
    private Player winner = null;
    private Collection<RSPGameOptions> player1Moves = new ArrayList<>();
    
    private Player looser = null;
    private Collection<RSPGameOptions> player2Moves = new ArrayList<>();
    
    public static enum Better {
        FIRST, SECOND, NONE;
    }

    /**
     * Constructor
     * @param id
     * @param player1
     * @param player2
     */
    public RSPGame(
        int id, Player player1, Player player2
    ) {
        super("RSP Game #" + id);
        
        assert player1 != null : "First user is not specified";
        assert player1.hasGameSkill(RSPGameSkill.class);
        this.player1 = player1;

        assert player2 != null : "Second user is not specified";;
        assert player2.hasGameSkill(RSPGameSkill.class);
        this.player2 = player2;
    }
    
    public Player getPlayer1() {
        return player1;
    }
    
    public Player getPlayer2() {
        return player2;
    }

    public Player getWinner() {
        return winner;
    }
    
    public Collection<RSPGameOptions> getPlayer1Moves() {
        return player1Moves;
    }
    
    public Player getLooser() {
        return looser;
    }
        
    public Collection<RSPGameOptions> getPlayer2Moves() {
        return player2Moves;
    }
    
    /**
     * 
     */
    @Override
    public void nextMove() {
        
        RSPGameOptions player1Move = player1.getGameSkill(RSPGameSkill.class).next();
        player1Moves.add(player1Move);
        
        RSPGameOptions player2Move = player2.getGameSkill(RSPGameSkill.class).next();
        player2Moves.add(player2Move);
        
        
        // 
        Better whichIsBetter = whichIsBetter( player1Move, player2Move );
        
        /*
         *  if both have the same result - game needs to be re-taken
         */
        if (whichIsBetter == Better.NONE) return;
        
        /*
         * Either way we have clear winner
         */
        this.winner = whichIsBetter == Better.FIRST ? player1 : player2;
        this.looser = whichIsBetter == Better.FIRST ? player2 : player1;
        
        this.isFinished = true;
    }

    /*
     * 
     */
    protected Better whichIsBetter( RSPGameOptions o1, RSPGameOptions o2 ) {
        if (o1 == o2) return Better.NONE;
        switch(o1) {
            case ROCK: return o2 == SCISSORS ? Better.FIRST : Better.SECOND;
            case SCISSORS: return o2 == PAPER ? Better.FIRST : Better.SECOND;
            case PAPER: return o2 == ROCK ? Better.FIRST : Better.SECOND;
            default: return Better.NONE;
        }
    }
    
    @Override
    public boolean isFinished() {
        return isFinished;
    }

}
