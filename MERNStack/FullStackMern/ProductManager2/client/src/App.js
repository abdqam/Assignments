import './App.css';
import Main from './views/Main'
import Detail from './components/Detail';
import { Router } from '@reach/router';


function App() {
  return (
    <div className="App">
      <Router>
        <Main path="/"/>
        <Detail path="products/:id" />
      </Router>
    </div>
  );
}

export default App;
