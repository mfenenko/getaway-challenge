package com.getaway.challenge.game.rsp.skill;

import com.getaway.challenge.game.rsp.RSPGameOptions;

/**
 * 
 */
public class StaticRSPGameSkill implements RSPGameSkill {

    private RSPGameOptions option;
    
    public StaticRSPGameSkill(RSPGameOptions option) {
        this.option = option;
    }
    
    @Override
    public RSPGameOptions next() {
        return option;
    }
}
