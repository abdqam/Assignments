import './App.css';
import { Router } from '@reach/router';
import Home from './components/Home';
import Word from './components/Word';
import StyledWord from './components/StyledWord';
function App() {
  return (
    <div className="App">
      <Router>
        <Home path="/home"/>
        <Word path="/:word"/>
        <StyledWord path="/:word/:bgcolor/:wcolor"/>
      </Router>
    </div>
  );
}

export default App;
