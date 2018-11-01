package com.example.blogservice.repositories;

import com.example.blogservice.models.Blog;
import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

/**
 * @author Jaime Rojas
 * Created on 11/1/2018.
 */
public interface BlogRepository extends Repository<Blog, Long> {
    Page<Blog> findAll(Pageable pageable);
    Blog findBySubject(String subject);
}
