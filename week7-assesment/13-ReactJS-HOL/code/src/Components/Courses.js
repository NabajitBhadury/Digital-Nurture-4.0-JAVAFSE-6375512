export default function Courses({
  coursesData,
}) {
  return (
    <div className="itemCard">
      {coursesData.map((course, index) => (
        <div key={index}>
          <h2>{course.name}</h2>
          <p>Date: {course.date}</p>
        </div>
      ))}
    </div>
  )
}
