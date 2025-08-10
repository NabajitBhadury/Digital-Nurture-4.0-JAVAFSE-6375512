import { SignIn } from "./Components/Signin";
import { Welcome } from "./Components/Welcome";
import { useState } from "react";

function App() {
  const [loggedIn, setLoggedIn] = useState(false);
  const login = () => setLoggedIn(true);
  const logout = () => setLoggedIn(false);
  if (loggedIn) {
    return <Welcome onClick={logout} />;
  } else {
    return <SignIn onClick={login} />;
  }
}

export default App;
