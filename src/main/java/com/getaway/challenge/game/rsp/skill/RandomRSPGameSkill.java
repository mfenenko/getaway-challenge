package com.getaway.challenge.game.rsp.skill;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.getaway.challenge.game.rsp.RSPGameOptions;

/**
 * Random 
 */
public class RandomRSPGameSkill implements RSPGameSkill {

    private List<RSPGameOptions> options;
    
    private Random random;
    
    /**
     * 
     * @param options
     */
    public RandomRSPGameSkill(List<RSPGameOptions> options) {
        this.options = options;
        this.random = ThreadLocalRandom.current();
    }
    
    
    public RSPGameOptions next() {
        return options.get( random.nextInt(options.size()) );
    }
    
}
