export default function Blogs({
  blogsData,
}) {
  return (
    <div className="itemCard">
      {blogsData.map((blog, index) => (
        <div key={index}>
          <h2>{blog.title}</h2>
          <p>Author: {blog.author}</p>
          <p>Content: {blog.content}</p>
        </div>
      ))}
    </div>
  )
}
