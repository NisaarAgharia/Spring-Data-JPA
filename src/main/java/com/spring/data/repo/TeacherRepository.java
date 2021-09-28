package com.spring.data.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.data.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	
}
