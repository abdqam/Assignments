import React, { useState } from 'react';


const UserForm = (props) => {
    const [firstname, setFirstName] = useState("");
    const [lastname, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [cnfrmPassword, setcnfrmPassword] = useState("");
    return (
        <div>
            <form>
                <div>
                    <label htmlFor="fristname">First Name: </label>
                    <input type="text" onChange={(e) => setFirstName(e.target.value)} />
                    {
                    firstname.length<2 && firstname.length!==0?
                    <p style={{color:'red'}}>First Name must be at least 2 characters</p>:
                    ""
                    }
                </div>
                <div>
                    <label>Last Name: </label>
                    <input type="text" onChange={(e) => setLastName(e.target.value)} />
                    {
                    lastname.length<2 && lastname.length!==0?
                    <p style={{color:'red'}}>Last Name must be at least 2 characters</p>:
                    ""
                    }
                </div>
                <div>
                    <label>Email Address: </label>
                    <input type="text" onChange={(e) => setEmail(e.target.value)} />
                    {
                    email.length<5 && email.length!==0?
                    <p style={{color:'red'}}>Email must be at least 5 characters</p>:
                    ""
                    }
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" onChange={(e) => setPassword(e.target.value)} />
                    {
                    password.length<8 && password.length!==0?
                    <p style={{color:'red'}}>Password must be at least 8 characters</p>:
                    ""
                    }
                </div>
                <div>
                    <label>Confirm Password: </label>
                    <input type="password" onChange={(e) => setcnfrmPassword(e.target.value)} />
                    {
                    password !== cnfrmPassword && cnfrmPassword.length!==0?
                    <p style={{color:'red'}}>Password and comfirm password mustmatch</p>:
                    ""
                    }
                </div>
            </form>
        </div>
    );
};
export default UserForm;