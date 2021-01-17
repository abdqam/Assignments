package com.pokemon;

public class PokemonTest {
    public static void main(String[] args) {
        Pokemon pokemon1 = new Pokemon(100,"meaw","electrical");
        Pokemon pokemon2 = new Pokemon(200,"Pikatcho","Help");
        Pokemon pokemon3 = new Pokemon(100,"Giglybuff","shittt");
        pokemon1.attackPokemon(pokemon2);
        pokemon2.attackPokemon(pokemon3);
        pokemon1.attackPokemon(pokemon3);
        Pokedex pokemonList = new Pokedex();
        pokemonList.addPokemon(pokemon1);
        pokemonList.addPokemon(pokemon2);
        pokemonList.addPokemon(pokemon3);
        pokemonList.listPokemon();


    }
}
