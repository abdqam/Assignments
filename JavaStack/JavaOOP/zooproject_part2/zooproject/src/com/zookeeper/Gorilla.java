package com.zookeeper;

public class Gorilla extends Mammal{

    public void throwSomthing(){
        int energy =getEnergyLevel()-5;
        setEnergyLevel(energy);
        System.out.println("thrown Somthing");
    }
    public void eatBananas(){
        int energy =getEnergyLevel()+10;
        setEnergyLevel(energy);
        System.out.println("eat Bananas");
    }
    public void climb(){
        int energy =getEnergyLevel()-10;
        setEnergyLevel(energy);
        System.out.println("climb");
    }

}
