package com.zookeeper;

public class Bat extends Mammal{
    public Bat() {
        setEnergyLevel(300);
    }
    public void fly(){
        int energy =getEnergyLevel()-50;
        setEnergyLevel(energy);
        System.out.println("the sound a bat taking off");
    }
    public void eatHumans(){
        int energy =getEnergyLevel()+25;
        setEnergyLevel(energy);
        System.out.println("so- well, never mind");
    }
    public void attackTown(){
        int energy =getEnergyLevel()-100;
        setEnergyLevel(energy);
        System.out.println("sound of a town on fire");
    }
}
