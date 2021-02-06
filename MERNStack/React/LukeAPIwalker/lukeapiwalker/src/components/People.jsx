import React, { useState } from 'react'
import axios from 'axios';

const People = (props) => {
    
    axios.get(props.displayData.homeworld).then(response => setplanet(response.data))
    const [planet,setplanet]=useState('');
    return (
        <div>
            <h3>{props.displayData.name}</h3>
            <p>Height: {props.displayData.height}</p>
            <p>Mass: {props.displayData.mass}</p>
            <p>Hair Color: {props.displayData.hair_color}</p>
            <p>Skin Color: {props.displayData.skin_color}</p>
            <p>HomeWorld: {planet.name}</p>
        </div>
    )
}
export default People