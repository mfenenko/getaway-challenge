package com.getaway.challenge.game.rsp.skill;

import com.getaway.challenge.domain.IGameSkill;
import com.getaway.challenge.game.rsp.RSPGameOptions;

public interface RSPGameSkill extends IGameSkill {

    public RSPGameOptions next();
    
}
