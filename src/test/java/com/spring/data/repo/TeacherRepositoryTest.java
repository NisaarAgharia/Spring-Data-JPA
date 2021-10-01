package com.spring.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.entity.Course;
import com.spring.data.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {
	
	@Autowired 
	TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		Course course = Course.builder().credits(5).title("Angualr").build();
		Teacher teacher = Teacher.builder().FirstName("blank").LastName("Blank")
				//.courses(List.of(course))
				.build();
		
		teacherRepository.save(teacher);
	}


}
