import React, { useState } from 'react'
import axios from 'axios'


const Login = (props) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errors, setErrors] = useState("");
    const login = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/login', {
            email, password
        }, { withCredentials: true })
            .then(response => { setErrors(""); props.loggedUser(response.data.user) })
            .catch((err) => setErrors("Invalid Login"))
    };
    return (
        <div>
            <form onSubmit={login}>
                <small style={{ color: "red" }}>{errors}</small>
                <div><label>Email: <input type="text" onChange={(e) => setEmail(e.target.value)} /></label></div>
                <div><label>Password: <input type="password" onChange={(e) => setPassword(e.target.value)} /></label></div>
                <div><a onClick={(e) => props.Registerd(false)}><span style={{ color: "blue", textDecoration: "underline" }}>You Don't have an account?</span></a></div>
                <button>Login</button>
            </form>
        </div>
    )
}
export default Login
