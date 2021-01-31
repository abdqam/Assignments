import React, { useState } from 'react';


const UserForm = (props) => {
    const [firstname, setFirstName] = useState("");
    const [lastname, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [cnfrmPassword, setcnfrmPassword] = useState("");

    const createUser = (e) => {
        e.preventDefault();
        const newUser = { firstname, lastname, email, password, cnfrmPassword};
        console.log(newUser);
    };
    return (
        <div>
            <form onSubmit={createUser}>
                <div>
                    <label htmlFor="fristname">First Name: </label>
                    <input type="text" onChange={(e) => setFirstName(e.target.value)} />
                </div>
                <div>
                    <label>Last Name: </label>
                    <input type="text" onChange={(e) => setLastName(e.target.value)} />
                </div>
                <div>
                    <label>Email Address: </label>
                    <input type="text" onChange={(e) => setEmail(e.target.value)} />
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" onChange={(e) => setPassword(e.target.value)} />
                </div>
                <div>
                    <label>Confirm Password: </label>
                    <input type="password" onChange={(e) => setcnfrmPassword(e.target.value)} />
                </div>
                <input type="submit" value="Create User" />
            </form>
            <div>
                <p>First Name: {firstname} </p>
                <p>Last Name: {lastname}</p>
                <p>Email: {email}</p>
                <p>Password: {password}</p>
                <p>Confirm Password: {cnfrmPassword}</p>
            </div>
        </div>
    );
};
export default UserForm;