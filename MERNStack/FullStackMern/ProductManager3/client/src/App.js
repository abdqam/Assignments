import './App.css';
import Main from './views/Main'
import Detail from './components/Detail';
import { Router } from '@reach/router';
import Update from './views/Update';


function App() {
  return (
    <div className="App">
      <Router>
        <Main path="/"/>
        <Detail path="products/:id" />
        <Update path="products/:id/edit"/>
      </Router>
    </div>
  );
}

export default App;
