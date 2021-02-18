import React, { useState } from 'react'
import Login from './Login';
import Register from './Register';

const Root = (props) => {
    const [registered, setRegisterd] = useState(false);
    const registerdUser = (userVal) => {
        props.signedUser(userVal);
    }
    const Registerd = (val) => {
        setRegisterd(val)
    }
    const loggedUser = (userVal) => {
        props.signedUser(userVal);
    }
    return (
        <div style={{ marginLeft: "30%", display: "flex", marginRight: "30%", justifyContent: "space-between", marginTop: "5%" }}>
            <div>
                {
                    registered ?
                        <Login loggedUser={loggedUser} Registerd={Registerd} /> :
                        <Register registerdUser={registerdUser} Registerd={Registerd} />
                }
            </div>
            <div>
                <h3>No data</h3>
            </div>
        </div>
    )
}
export default Root