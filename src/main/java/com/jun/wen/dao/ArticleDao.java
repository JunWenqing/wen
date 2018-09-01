package com.jun.wen.dao;

import com.jun.wen.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article, String> {

    public List<Article> findAllByCategory_Name(String name);

    @Query("from Article where title like %:title%")
    public List<Article> findByTitleLike(@Param("title") String title);
}
