package com.pokemon;

public class Pokemon {
    private int health =100;
    private String name="";
    private String Type="";
    private static int count=0;

    public Pokemon() {
    count++;
    }

    public Pokemon(int health, String name, String type) {
        this.health = health;
        this.name = name;
        Type = type;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void attackPokemon(Pokemon pokemon){
        int attacked = pokemon.getHealth()-10;
        pokemon.setHealth(attacked);

    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
