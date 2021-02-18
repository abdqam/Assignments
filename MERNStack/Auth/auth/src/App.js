import './App.css';
import Root from './components/Root';
import Success from './components/Success';
import axios from 'axios'
import React, { useEffect, useState } from 'react'

function App() {
  const [user, setUser] = useState({ _id: false });
  const logout = (val) => {
    axios.get('http://localhost:8000/api/logout', { withCredentials: true })
      .then(() => { setUser({ _id: false }); })
      .catch(err => console.log(err))
  }
  useEffect(() => {
    axios.get('http://localhost:8000/api/tokenuser', { withCredentials: true })
      .then(res => { setUser(res.data); })
      .catch(err => console.log("Unauthorized"));
  }, [user._id])
  const signedUser = (data) => {
    setUser(data)
  }
  return (
    <div className="App">
      {
        user._id ?
          <Success user={user} logout={logout} /> :
          <Root user={user} signedUser={signedUser} />
      }
    </div>
  );
}
export default App;
