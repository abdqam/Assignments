import React from 'react'

const Planet = (props) => {
    return (
        <div>
            <h3>{props.displayData.name}</h3>
            <p>Climate: {props.displayData.climate}</p>
            <p>Terrain: {props.displayData.terrain}</p>
            <p>Surface Water: {props.displayData.surface_water}</p>
            <p>Population: {props.displayData.population}</p>
        </div>
    )
}

export default Planet
