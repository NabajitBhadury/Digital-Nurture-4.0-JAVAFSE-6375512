import './App.css';
import CohortCard from './components/cohort_card';
import CohortDetail from './CohortDetail';

const cohortsData = [
  new CohortDetail(
    "INTADMDF10 - .NET FSD",
    "22-Feb-2022",
    "Scheduled",
    "Aathma",
    "Jojo Jose"
  ),
  new CohortDetail(
    "ADM21JF014 - Java FSD",
    "10-Sep-2021",
    "Ongoing",
    "Apoorv",
    "Elisa Smith"
  ),
  new CohortDetail(
    "CDBJF21025 - Java FSD",
    "24-Dec-2021",
    "Ongoing",
    "Aathma",
    "John Doe"
  ),
];


function App() {
  return (
    <div className="app-container">
      <h1 className="app-title">Cohorts Details</h1>
      <div className="cohorts-grid">
        {cohortsData.map((cohort, index) => (
          <CohortCard key={index} cohort={cohort} />
        ))}
      </div>
    </div>
  );
}

export default App;
