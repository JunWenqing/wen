package com.jun.wen.dao;

import com.jun.wen.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,String > {

    @Query("from User u where u.userName = :userName and u.password = :password")
    User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);


}
