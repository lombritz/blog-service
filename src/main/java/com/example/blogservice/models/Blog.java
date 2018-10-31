package com.example.blogservice.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaime Rojas
 * Created on 10/31/2018.
 */
public class Blog {
  private Long id;
  private String subject;

  private List<Post> posts;

  public Blog() {
    this.posts = new ArrayList<>();
  }

  public Blog(Long id, String subject) {
    this.id = id;
    this.subject = subject;
    this.posts = new ArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  @Override
  public String toString() {
    return "Blog{" +
        "id=" + id +
        ", subject='" + subject + '\'' +
        ", posts=" + posts +
        '}';
  }
}
