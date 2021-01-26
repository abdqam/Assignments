package com.objectmaster;

public class Wizard extends Human{
    public Wizard(){
        this.setHealth(50);
        this.setIntelligence(8);
    }
    public void heal(Human h){
        h.setHealth(h.getHealth()+this.getIntelligence());
    }
    public void fireball(Human h){
        h.setHealth(h.getHealth() - this.getIntelligence()*3);
    }
}
