import React from 'react'
import { Link } from '@reach/router';

const ProductsList = (props) => {
    return (
        <div>
            {
            props.products.map((product, index)=> <p><Link to={`/products/${product._id}`} key={index}>{product.title}</Link></p>)
            }
        </div>
    )
}

export default ProductsList