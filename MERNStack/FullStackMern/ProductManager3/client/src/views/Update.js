import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link,navigate } from '@reach/router';

const Update = (props) => {
    const { id } = props;
    const [title, setTitle] = useState("");
    const [price, setPrice] =useState(0);
    const [description, setDescription] = useState("");
    useEffect(() => {
        axios.get('http://localhost:8000/api/products/' +id)
        .then (res => {
            setTitle(res.data.title);
            setPrice(res.data.price);
            setDescription(res.data.description);
        })
    },[])

    const updateHandler = e => {
        e.preventDefault();
        axios.put('http://localhost:8000/api/products/'+id, {
            title,price,description
        })
            .then(response => navigate("/"));
    }


    return (
        <div>
            <form onSubmit={updateHandler}>
            <h3>Update Product </h3>
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
            <div>
                <Link to ="/"> Back</Link>
            </div>
        </div>
    )
}

export default Update
