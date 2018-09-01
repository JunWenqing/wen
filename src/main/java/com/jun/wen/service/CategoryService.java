package com.jun.wen.service;

import com.jun.wen.dao.CategoryDao;
import com.jun.wen.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 如何添加一个类别，改变一个类别
 */
@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    /**
     * Query all by category
     * @return
     */
    public List<Category> list(){
        List<Category> categories = categoryDao.findAll();
        return categories;
    }

    /**
     *
     * @param id
     * @return one category
     */
    public Category get(String id){
        return categoryDao.getOne(id);
    }

    /**
     *
     * @param name
     * @return category
     */
    public Category findByName(String name){
        return categoryDao.findByName(name);
    }
}
