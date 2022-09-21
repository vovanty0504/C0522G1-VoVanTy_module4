package com.codegym.repository;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findById(int id);

    @Query(value = "select b.title, c.category_name as categoryName, b.id from blog as b join category as c on b.category_id = c.id", nativeQuery = true,
            countQuery = "select count(*) from (select b.title, c.category_name as categoryName, b.id from blog as b join category as c on b.category_id = c.id) temp_table")
    Page<BlogDto> showList(Pageable pageable);


    @Query(value = "select b.title, c.category_name as categoryName, b.id from blog as b join category as c on b.category_id = c.id where title like %:titleSearch%",nativeQuery = true,
            countQuery = "select count(*) from (select b.title, c.category_name as categoryName , b.id from blog as b join category as c on b.category_id = c.id where title like %:titleSearch%) temp_table")
    Page<BlogDto> findTitle(@Param("titleSearch") String name, Pageable pageable);


}
