import './App.css';
import { useState } from 'react';


function App() {
  const [count, setCount] = useState(0);

  const [currency, setCurrency] = useState(0);

  const increment = () => setCount(count + 1);
  const decrement = () => setCount(count - 1);

  const sayWelcome = () => alert('Welcome to Event Example App!');
  const clickMe = () => alert('I was clicked!');

  const convertRupeeToEuro = () => {
    const rupees = currency;
    const euros = rupees * 0.01;
    alert(`You have ${euros} euros`);
  }
  return (
    <div className="App">
      <h1>Event Example App</h1>
      <p className="count">Count: {count}</p>
      <div className="counter">
        <button className="button" onClick={increment}>Increment</button>
        <button className="button" onClick={decrement}>Decrement</button>
      </div>
      <button className="button" onClick={sayWelcome}>Say Welcome</button>
      <button className="button" onClick={clickMe}>Click Me</button>

      <div className="Currency Form">
        <label>Enter Amount: </label>
        <input type="number" value={currency} onChange={(e) => setCurrency(e.target.value)} />
        <button className="button" onClick={convertRupeeToEuro}>Convert</button>
      </div>




    </div>
  );
}

export default App;
