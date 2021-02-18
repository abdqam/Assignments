import React from 'react'
import axios from 'axios';
import { Link } from '@reach/router';

const ProductsList = (props) => {
    const deleteHandler = (id) => {
        axios.delete('http://localhost:8000/api/products/'+id)
        .then(response => console.log("deleted"))
    }
    return (
        <div>
            {
            props.products.map((product, index)=> <p><Link to={`/products/${product._id}`} key={index}>{product.title}</Link> | <button onClick={(e) => {deleteHandler(product._id)}}>Delete</button></p>)
            }
        </div>
    )
}
export default ProductsList