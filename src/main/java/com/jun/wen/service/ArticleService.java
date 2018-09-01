package com.jun.wen.service;

import com.jun.wen.dao.ArticleDao;
import com.jun.wen.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     *
     * @param id
     * @return 单条文章
     */
    public Article getById(String id){
        Article article = articleDao.getOne(id);

        return  article;
    }

    /**
     *
     * @return 所有列表
     */
    public List<Article> list(){
        List<Article> articles = articleDao.findAll();

        return articles;
    }

    /**
     *
     * @param categoryName
     * @return
     */
    public List<Article> getArticleByCategoryName(String categoryName){
        return articleDao.findAllByCategory_Name(categoryName);
    }

    /**
     * Delete
     * @param id
     */
    public void delete(String id){
        articleDao.deleteById(id);
    }

    /**
     * Save
     */
    public void save(Article article){
        articleDao.save(article);
    }

    /**
     * search by title
     */
    public List<Article> search(String title){
        return  articleDao.findByTitleLike(title);
    }
}
