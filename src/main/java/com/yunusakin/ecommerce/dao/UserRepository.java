package com.yunusakin.ecommerce.dao;

import com.yunusakin.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {


    @Query(value = "SELECT *FROM USERS WHERE USER_NAME=:userName ",nativeQuery = true)
    public User getUserByUsername(@Param("userName") String username);
}
