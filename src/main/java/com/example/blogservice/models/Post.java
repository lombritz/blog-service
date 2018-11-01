package com.example.blogservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Jaime Rojas
 * Created on 10/31/2018.
 */
@Entity
@Table(name = "POSTS")
public class Post {
  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private String content;

  @ManyToOne
  @JoinColumn(name = "BLOG_ID")
  private Blog blog;

  public Post() {
  }

  public Post(Long id, String title, String content, Blog blog) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.blog = blog;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Blog getBlog() {
    return blog;
  }

  public void setBlog(Blog blog) {
    this.blog = blog;
  }

  @Override
  public String toString() {
    return "Post{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", blog=" + blog +
        '}';
  }
}
