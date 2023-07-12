package com.codegym.ClimaxStoreSpring.service;

import com.codegym.ClimaxStoreSpring.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityNotFoundException;

public interface UserService extends GenericService<User> {

//    @Query("select u from User u where u.userName = :loginString or u.email = :loginString or u.phoneNumber = :loginString")
//    User findUser(@Param("loginString") String loginString);
    User findByUserName(String userName) throws EntityNotFoundException;
}
