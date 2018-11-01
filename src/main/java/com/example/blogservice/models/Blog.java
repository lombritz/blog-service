package com.example.blogservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaime Rojas
 * Created on 10/31/2018.
 */
@Entity
@Table(name = "BLOGS")
public class Blog {
  @Id
  @GeneratedValue
  private Long id;
  private String subject;

  @OneToMany
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
