import axios from 'axios'
import React, { useEffect, useState } from 'react'

const Success = (props) => {
    const [favBooks, setFavBooks] = useState(props.user.books);
    const [books, setBooks] = useState([]);
    useEffect(() => {
        axios.get('http://localhost:8000/api/allbooks', { withCredentials: true })
            .then(res => { setBooks(res.data) })
            .catch(err => console.log(err));
    }, []);
    const addToFav = (id) => {
        axios.put('http://localhost:8000/api/addtofav/' + props.user._id, { id })
            .then(res => { setFavBooks(res.data.books); })
            .catch(err => console.log(err));
    }
    return (
        <div style={{ marginLeft: "30%", display: "flex", marginRight: "30%", justifyContent: "space-between", marginTop: "5%" }}>
            <div>
                <h3>list of books {props.user.country.name}</h3>
                {books.map((book, index) => <div key={index}>{book.name} <button onClick={(e) => addToFav(book._id)}>Add to Favorite</button></div>)}
            </div>
            <div>
                {
                    props.user._id ?
                        <div>
                            <h3>welcome {props.user.firstName} <button onClick={(e) => props.logout(false)}>Logout</button> </h3>
                            <h3>My favorite Books</h3>
                            <div>{favBooks.map((book, index) => <p key={index}>{book.name}</p>)}</div>
                        </div> :
                        <h3>No data</h3>
                }
            </div>
        </div>
    )
}
export default Success
