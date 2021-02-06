import React, { useState } from 'react'
const Root = (props) => {
    const [input, setInput] = useState('people');
    const [id,setId] = useState(0);
    const inputHandler=(e)=>{
        setInput(e.target.value)
    }
    const idHandler=(e)=>{
        setId(e.target.value)
    }
    return (
        <>
            <div>
                <label>Search For: 
                    <select name="inputtype" id="inputType" onChange={inputHandler}>
                        <option value="people">People</option>
                        <option value="planets">Planets</option>
                    </select>
                </label>
                <label> ID:<input type="number" name="id" onChange={idHandler}/></label>
                <input type="button" value="Search!" onClick={()=>props.data(input,id)}/>
            </div>
            {/* <div>{props.error}</div> */}
        </>
    )
}
export default Root