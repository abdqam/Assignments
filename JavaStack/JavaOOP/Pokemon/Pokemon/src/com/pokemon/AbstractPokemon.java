package com.pokemon;

public abstract class AbstractPokemon implements PokemonInterface {
        public Pokemon createPokemon(String name, int health, String type){
            Pokemon pokemon=new Pokemon(health,name,type);
            return pokemon;
        }
        public String pokemonInfo(Pokemon pokemon){
            return "Name: "+ pokemon.getName()+ "Type: "+ pokemon.getType()+"Health: "+pokemon.getHealth();
        }
}
