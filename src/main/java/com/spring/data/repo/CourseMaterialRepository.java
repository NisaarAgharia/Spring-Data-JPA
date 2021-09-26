package com.spring.data.repo;


import org.springframework.stereotype.Repository;

import com.spring.data.entity.CourseMaterial;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long>{

}
