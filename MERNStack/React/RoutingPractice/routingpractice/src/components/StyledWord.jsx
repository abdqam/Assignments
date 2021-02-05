import React from 'react'

const StyledWord = (props) => {
    return (
        <div style={{background:props.bgcolor,padding:"20px",width:"100%",color:props.wcolor}}>
            <h3>The Word is : {props.word}</h3>
        </div>
    )
}

export default StyledWord
