package com.example.blogservice.controllers;

import com.example.blogservice.models.Blog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Jaime Rojas
 * Created on 10/31/2018.
 */
@RestController
public class BlogController {
  private List<Blog> blogs;

  public BlogController() {
    blogs = new ArrayList<>();
  }

  @GetMapping(path = "/blog")
  public List<Blog> getBlogs() {
    return blogs;
  }

  @GetMapping(path = "/blog/{id}")
  public Blog getBlog(@PathVariable Long id) {
    return blogs.stream()
        .filter(blog -> blog.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new RuntimeException(
            String.format("Couldn't find blog{id=%d}!", id)));
  }

  @PostMapping(path = "/blog")
  public Blog createBlog(@RequestBody Blog blog) {
    Long maxID = blogs.stream().mapToLong(Blog::getId).max().orElse(0);
    blog.setId(maxID + 1);
    if (!blogs.add(blog)) {
      throw new RuntimeException("Failed creating blog!");
    }
    return blog;
  }

  @PutMapping(path = "/blog")
  public Blog updateBlog(@RequestBody Blog updated) {
    Optional<Blog> blog = blogs.stream()
        .filter(b -> b.getId().equals(updated.getId()))
        .findFirst();

    blog.ifPresent(b -> {
      b.setSubject(updated.getSubject());
      b.setPosts(updated.getPosts());
    });

    return blog.orElseThrow(() -> new RuntimeException(
            String.format("Couldn't find blog{id=%d}!", updated.getId())));
  }

}
