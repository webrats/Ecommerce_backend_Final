package com.mvc.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.reg.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
