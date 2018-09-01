package com.jun.wen.dao;

import com.jun.wen.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, String> {

    Category findByName(String  name);
}
