import './App.css';
import Details from './views/Details';
import Main from './views/Main'
import { Router } from '@reach/router';

function App() {
  return (
    <div className="App">
      <Router>
      <Main path="/"/>
      <Details path="/products/:id"/>
      </Router>
    </div>
  );
}

export default App;
