import React from 'react'
import { Link } from '@reach/router';
import axios from 'axios';


const ProductsList = (props) => {
    const deleteHandler = (id) => {
        axios.delete('http://localhost:8000/api/products/'+id)
        .then(response => console.log("deleted"))
    }
    return (
        <div>
            {
            props.products.map((product, index)=><p key={index}><Link to ={`/products/${product._id}`}>{product.title}</Link> | <button onClick={(e) => {deleteHandler(product._id)}}>Delete</button>
            </p>)
            }
        </div>
    )
}

export default ProductsList
