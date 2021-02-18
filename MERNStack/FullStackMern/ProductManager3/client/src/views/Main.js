import axios from 'axios';
import React, { useEffect, useState } from 'react';
import NewProductForm from '../components/NewProductForm';
import ProductsList from '../components/ProductsList';

export default () => {
    const [products, setProducts] = useState([]);
    const [loaded, setLoaded] = useState(false);
    useEffect(()=>{
        axios.get('http://localhost:8000/api/products')
        .then(res => {
            setProducts(res.data);
            setLoaded(true);
        });
        
    },[products])
    return (
        <div>
            <NewProductForm/>
            <hr/>
            {loaded && <ProductsList products={products}/>}
        </div>
    )
}