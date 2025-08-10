import './App.css';
import { useState } from 'react';
import Books from './Components/Books';
import Blogs from './Components/Blogs';
import Courses from './Components/Courses';


const booksData = [
  { id: 'b1', bname: 'Master React', price: 670 },
  { id: 'b2', bname: 'Deep Dive into Angular 11', price: 800 },
  { id: 'b3', bname: 'Mongo Essentials', price: 450 },
];

const blogsData = [
  { id: 'g1', title: 'React Learning', author: 'Stephen Biz', content: 'Welcome to learning React!' },
  { id: 'g2', title: 'Installation', author: 'Schewzdenier', content: 'You can install React from npm.' },
];

const coursesData = [
  { id: 'c1', name: 'Angular', date: '4/5/2021' },
  { id: 'c2', name: 'React', date: '6/3/2020' },
];

function App() {
  const selections = ["All", "Books", "Blogs", "Courses"];
  const [selected, setSelected] = useState("All");


  return (
    <div className="App">
      <header className="App-header">
        <h1>Blogger App</h1>
        <div className="selections">
          {selections.map((item, index) => (
            <button key={index} className={selected === item ? 'button-selected button' : 'button'} onClick={() => setSelected(item)}>
              {item}
            </button>
          ))}
        </div>
      </header>
      <div className="body">
        {/* <Books booksData={booksData} /> */}
        {/* <Blogs blogsData={blogsData} /> */}
        {/* <Courses coursesData={coursesData} /> */}
        {(selected === "All" || selected === "Books") && <Books booksData={booksData} />}
        {(selected === "All" || selected === "Blogs") && <Blogs blogsData={blogsData} />}
        {(selected === "All" || selected === "Courses") && <Courses coursesData={coursesData} />}

      </div>
    </div>
  );
}

export default App;
