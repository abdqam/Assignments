import React, {useState, useEffect} from 'react'
import { Button } from '@material-ui/core';

const Pokemon = () => {
    const[pokemon, setPokemon] = useState([]);
    const onClickHandler = () => {
        fetch("https://pokeapi.co/api/v2/pokemon/?limit=807")
        .then(response => response.json() )
        .then(response => setPokemon(response.results) )
    };
    return (
        <div>
            <Button variant="contained" color="secondary" onClick={onClickHandler}>Get Pokemon</Button>
            <ol>{pokemon.length > 0 && pokemon.map((pokemon) =><li>{pokemon.name}</li>)}</ol>
        </div>
) 
}

export default Pokemon
