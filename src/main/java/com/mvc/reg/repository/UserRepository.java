package com.mvc.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.reg.model.UserDao;
@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {

	UserDao findByUsername(String username) ;
}
