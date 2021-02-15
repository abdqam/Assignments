import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link, navigate } from '@reach/router';

const Detail = (props) => {
    const [product, setProduct] = useState("")
    useEffect(() => {
        axios.get("http://localhost:8000/api/products/" + props.id)
            .then(res => setProduct(res.data))
    }, [])
    const deleteHandler = (id) => {
        axios.delete('http://localhost:8000/api/products/'+id)
        .then(response => navigate("/"))
    }
    return (
        <div>
            <h3>{product.title}</h3>
            <p>Price: {product.price}</p>
            <p>Description: {product.description}</p>
            <p><Link to ={`/products/${product._id}/edit`}>Edit</Link></p>
            <button onClick={(e) => {deleteHandler(product._id)}}>Delete</button>
        </div>
    )
}

export default Detail
