import React from "react";
import styles from "./Posts.module.css";

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null,
    };
  }

  async loadPosts() {
    try {
      const postapi = "https://jsonplaceholder.typicode.com/posts";
      const response = await fetch(postapi);
      if (!response.ok) {
        throw new Error('Failed to fetch posts');
      }
      const posts = await response.json();
      this.setState({ posts: posts });
    } catch (error) {
      this.setState({ error: error });
    }
  }

  componentDidMount() {
    this.loadPosts();
  }

  render() {
    const { posts, error } = this.state;

    if (error) {
      return <div>Error: {error.message}</div>;
    }

    if (!posts || posts.length === 0) {
      return <div>Loading...</div>;
    }

    return (
      <div className={styles.posts}>
        <ul className={styles.postsList}>
          {posts.map(post => (
            <li key={post.id}>
              <h2>{post.title}</h2>
              <p>{post.body}</p>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default Posts;
