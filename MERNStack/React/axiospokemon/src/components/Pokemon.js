import React, {useState} from 'react'
import { Button } from '@material-ui/core';
import axios from 'axios';

const Pokemon = () => {
    const[pokemon, setPokemon] = useState([]);
    const onClickHandler = () => {
        axios.get("https://pokeapi.co/api/v2/pokemon/?limit=807")
        .then(response => setPokemon(response.data.results) )
    };
    return (
        <div>
            <Button variant="contained" color="secondary" onClick={onClickHandler}>Get Pokemon</Button>
            <ol>{pokemon.length > 0 && pokemon.map((pokemon) =><li>{pokemon.name}</li>)}</ol>
        </div>
)
}

export default Pokemon
