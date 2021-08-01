package com.mvc.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.reg.model.PostDao;
@Repository
public interface PostRepository extends JpaRepository<PostDao, Long> {

}
