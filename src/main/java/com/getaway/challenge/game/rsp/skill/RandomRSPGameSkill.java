package com.getaway.challenge.game.rsp.skill;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.getaway.challenge.game.rsp.RSPGameOptions;

/**
 * Random 
 */
public class RandomRSPGameSkill implements RSPGameSkill {

    private List<RSPGameOptions> options;
    
    /**
     * 
     * @param options
     */
    public RandomRSPGameSkill(List<RSPGameOptions> options) {
        this.options = options;
    }
    
    
    public RSPGameOptions next() {
        return options.get(ThreadLocalRandom.current().nextInt(options.size()));
    }
    
}
