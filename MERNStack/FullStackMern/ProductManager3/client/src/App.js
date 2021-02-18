import './App.css';
import Details from './views/Details';
import Main from './views/Main'
import { Router } from '@reach/router';
import Update from './views/Update';

function App() {
  return (
    <div className="App">
      <Router>
      <Main path="/"/>
      <Details path="/products/:id"/>
      <Update path="/products/:id/edit"/>
      </Router>
    </div>
  );
}

export default App;
