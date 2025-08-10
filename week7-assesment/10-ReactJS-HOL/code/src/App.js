import { Header } from "./Components/Header";
import { OfficeComponent } from "./Components/Office";
import { offices } from "./office";

function App() {
  return (
    <div className="App">
      <Header />
      <img src="./office.jpg" width="20%" height="20%" />
      {offices.map((office) => (
        <OfficeComponent office={office} />
      ))}
    </div>
  );
}

export default App;
