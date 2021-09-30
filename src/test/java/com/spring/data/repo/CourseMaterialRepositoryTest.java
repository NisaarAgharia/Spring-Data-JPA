package com.spring.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.entity.Course;
import com.spring.data.entity.CourseMaterial;

import lombok.Builder;

@SpringBootTest
public class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepo;

	@Test
	public void SaveCourseMaterial() {
		
		Course course = Course.builder()
				.credits(4).title("react").build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder().
				course(course).
				url("osReact.com").
				build();
		
		courseMaterialRepo.save(courseMaterial);
	}
	
	@Test
	public void showAllCourseMaterial()
	{
		List <CourseMaterial> CMLIST = courseMaterialRepo.findAll();
		System.out.println("CM LIST "+ CMLIST );
	}
}
