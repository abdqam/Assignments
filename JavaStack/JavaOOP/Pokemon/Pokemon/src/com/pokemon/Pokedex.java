package com.pokemon;

import java.util.ArrayList;

public class Pokedex extends AbstractPokemon{
    ArrayList<Pokemon> myPokemons=new ArrayList<Pokemon>();

    public void addPokemon(Pokemon pokemon){
        myPokemons.add(pokemon);
    }
    @Override
    public void listPokemon() {
        for (Pokemon i:myPokemons ){
            System.out.println(i.getName());
        }
    }
}
