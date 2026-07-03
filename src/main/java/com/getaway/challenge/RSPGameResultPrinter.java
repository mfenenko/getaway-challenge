package com.getaway.challenge;

import com.getaway.challenge.domain.AbstractGame;
import com.getaway.challenge.game.listener.GameEngineListener;
import com.getaway.challenge.game.rsp.RSPGame;
import com.getaway.challenge.game.rsp.RSPGameOptions;

public class RSPGameResultPrinter implements GameEngineListener {

    @Override
    public void onFinished(AbstractGame g) {
        
        if ( !(g instanceof RSPGame) ) return;
        
        RSPGame game = (RSPGame) g;
        
        System.out.println("""
            Game number:  %s
            %s's moves:   %s
            %s's moves:   %s
            Winner:          %s
                """.formatted(
            game.getGameId(),
            game.getPlayer1(), String.join(", ", game.getPlayer1Moves().stream().map(RSPGameOptions::name).toList()),
            game.getPlayer2(), String.join(", ", game.getPlayer2Moves().stream().map(RSPGameOptions::name).toList()),
            game.getWinner()
        ));
    }

}
