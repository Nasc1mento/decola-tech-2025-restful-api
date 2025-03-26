# Decola Tech 2025 - Spring Lab 
Java Restful blog API

## Class Diagram
``` mermaid
classDiagram
  class User {
    -String username
    -String password
    -Post[] posts
    -Comment[] comments
  }

  class Post {
    -String title
    -String content
    -User creator
    -Like[] likes
    -Comment[] comments
  }

  class Comment {
    -String content
  }

  class Like {
    -User user
    -Post post
  }

  User "1" *-- "N" Post
  User "1" *-- "N" Like
  User "1" *-- "N" Comment
  Post "1" *-- "N" Like
  Post "1" *-- "N" Comment

``` 
