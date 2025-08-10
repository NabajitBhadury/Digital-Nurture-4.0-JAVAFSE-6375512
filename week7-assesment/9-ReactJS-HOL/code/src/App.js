import players from "./players";
import Comp1 from "./Components/Comp1";
import Comp2 from "./Components/Comp2";

function App() {
  const flag = true;
  if (flag) {
    return <Comp1 players={players} />;
  } else {
    return <Comp2 players={players} />;
  }
}

export default App;
