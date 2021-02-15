import React, { useState } from 'react'
import axios from 'axios';
export default () => {
    const [title, setTitle] = useState("");
    const [price, setPrice] =useState(0);
    const [description, setDescription] = useState("");
    const onSubmitHandler = e => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/products', {
            title,
            description,
            price
        })
            .then(res=>console.log(res))
            .catch(err=>console.log(err))
    }
    return (
        <form onSubmit={onSubmitHandler}>
            <h3>Product Manager</h3>
            <p>
                <label>Title: <input type="text" onChange={(e)=>setTitle(e.target.value)} value={title}/></label><br/>
                
            </p>
            <p>
                <label>Price: <input type="text" onChange={(e)=>setPrice(e.target.value)} value={price}/></label><br/>
                
            </p>
            <p>
                <label>Description: <input type="text" onChange={(e)=>setDescription(e.target.value)} value={description}/></label><br/>
                
            </p>
            <input type="submit"/>
        </form>
    )
}