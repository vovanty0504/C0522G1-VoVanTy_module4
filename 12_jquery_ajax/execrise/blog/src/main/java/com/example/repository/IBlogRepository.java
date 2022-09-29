package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog where category_id = :id", nativeQuery = true)
    List<Blog> showBlogCategory(@Param("id")int id );

    List<Blog> findByNameContains(String name);

}
