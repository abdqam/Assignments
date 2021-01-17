package com.objectmaster;

public class Samurai extends Human{
    private static int count_static = 0;
    public Samurai() {
        this.setHealth(200);
        count_static++;
    }
    public void deathBlow(Human h){
        h.setHealth(0);
        this.setHealth(this.getHealth()/2);
    }
    public void meditate(){
        this.setHealth(this.getHealth()+this.getHealth()/2);
    }
    public static int hoeMany_static(){
        return count_static;
    }
}
