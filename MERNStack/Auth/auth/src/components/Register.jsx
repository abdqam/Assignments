import React, { useEffect, useState } from 'react'
import axios from 'axios'

const Register = (props) => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [country, setCountry] = useState('Click to select');
    const [countries, setCountries] = useState([]);
    const [errors, setErrors] = useState([]);
    useEffect(() => {
        axios.get('http://localhost:8000/api/allcountries')
            .then(res => setCountries(res.data))
            .catch(err => console.log(err));
    }, [])
    const register = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/register', {
            firstName, lastName, email, password, country
        }, { withCredentials: true })
            .then(response => props.registerdUser(response.data.user))
            .catch(err => {
                const errorResponse = err.response.data.errors;
                const errorArr = [];
                for (const key of Object.keys(errorResponse)) {
                    errorArr.push(errorResponse[key].message)
                }
                setErrors(errorArr);
            })
    };
    return (
        <div>
            {
                errors.map((err, index) => <small key={index} style={{ color: "red" }}>{err}<br /></small>)
            }
            <form onSubmit={register}>
                <div><label>First Name: <input type="text" onChange={(e) => setFirstName(e.target.value)} /></label></div>
                <div><label>Last Name: <input type="text" onChange={(e) => setLastName(e.target.value)} /></label></div>
                <div><label>Email: <input type="text" onChange={(e) => setEmail(e.target.value)} /></label></div>
                <div><label>Country: <select onChange={(e) => setCountry(e.target.value)}>{countries.map((count, index) => <option key={index} value={count._id}>{count.name}</option>)} </select></label></div>
                <div><label>Password: <input type="password" onChange={(e) => setPassword(e.target.value)} /></label></div>
                <div><a onClick={(e) => props.Registerd(true)}><span style={{ color: "blue", textDecoration: "underline" }}>Already have an account?</span></a></div>
                <button>Register</button>
            </form>
        </div>
    )
}
export default Register