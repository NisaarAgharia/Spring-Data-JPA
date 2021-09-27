package com.spring.data.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.data.entity.Student;

@Component
public class StudentDataService {

	@Autowired
	StudentRepository studentRepo;
	
	public void SaveStudentInfo(Student s)
	{
		studentRepo.save(s);
	}
}
