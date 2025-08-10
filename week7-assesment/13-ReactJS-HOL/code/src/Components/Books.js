import './Book.css';

export default function Books({
  booksData,
}) {

  return (
    <div className="itemCard">
      {booksData.map((book, index) => (
        <div key={index}>
          <h2>{book.bname}</h2>
          <p>Price: {book.price}</p>
        </div>
      ))}
    </div>
  )
}
