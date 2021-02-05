import React from 'react'

const Word = (props) => {
    return (
        <div>{
            isNaN(props.word)?
            <h3>The Word is : {props.word}</h3>:
            <h3>The Number is : {props.word}</h3>
        }
        </div>
    )
}

export default Word