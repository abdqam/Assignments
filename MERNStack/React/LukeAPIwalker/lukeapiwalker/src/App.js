import './App.css';
import {Router,navigate} from '@reach/router';
import Root from './components/Root';
import Planet from './components/Planet';
import People from './components/People';
import {useState} from 'react';
import axios from 'axios';

function App() {
  const [input,setInput] = useState('');
  // const [error,setError] = useState('');
  const dataHandler= (data,id)=>{
    axios.get(`https://swapi.dev/api/${data}/${id}/`).then(response => {setInput(response.data); navigate(`/${data}/${id}`);})
    // .catch(()=>{setError("These aren't the droids you're looking for");setError("")})
  }
  return (
    <div className="App">
      <Root data={dataHandler}/>
      <Router>
        <Planet displayData={input} path="/planets/:id/" />
        <People displayData={input} path="/people/:id/" />
      </Router>
    </div>
  );
}

export default App;
