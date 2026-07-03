package com.getaway.challenge.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 */
public class Player {

    private String id;
    private String name;
    private Collection<IGameSkill> gameSkills = new ArrayList<>();
   
    /**
     * 
     * @param id
     * @param name
     */
    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public void addGameSkill(IGameSkill newSkill) {
        this.gameSkills.add(newSkill);
    }
    
    public <T extends IGameSkill> boolean hasGameSkill(Class<T> c) {
        return getGameSkill(c) != null;
    }
    
    public <T extends IGameSkill> T getGameSkill(Class<T> c) {
        for (IGameSkill skill : gameSkills) {
            if (c.isInstance(skill)) {
                return (T) skill;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
