package com.spring.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
