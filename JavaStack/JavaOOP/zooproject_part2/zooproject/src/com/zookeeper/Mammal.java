package com.zookeeper;

public class Mammal {
    private int energyLevel = 100;

    public int getEnergyLevel() {
        return energyLevel;
    }

    public Mammal() {
    }

    public Mammal(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }
    public int displayEnergy(){
        System.out.println(getEnergyLevel());
        return getEnergyLevel();
    }
}
