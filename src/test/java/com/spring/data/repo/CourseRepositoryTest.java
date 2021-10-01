package com.spring.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.spring.data.entity.Course;
import com.spring.data.entity.Student;
import com.spring.data.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository courseRepo;

	@Test
	public void getAllCourses()
	{
		List<Course> courseList = courseRepo.findAll();
		System.out.println(courseList);
	}
	
	@Test
	public void saveCourseWithTeacher()
	{
		Teacher teacher = Teacher.builder().FirstName("Sam").LastName("Matt").build();
		Course course = Course.builder().credits(6).title("English").teacher(teacher).build();
	courseRepo.save(course);
	
	}
	@Test
	public void findAllPagination()
	{
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3,Sort.by("courseID"));
		
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
		
		List<Course> course =courseRepo.findAll(firstPageWithThreeRecords).getContent();
		
		Long totalElements = courseRepo.findAll(firstPageWithThreeRecords).getTotalElements();
		
		int totalPages = courseRepo.findAll(firstPageWithThreeRecords).getTotalPages();
		
		
		
		System.out.println("Total Elements " + totalElements);
		System.out.println("Pages " + totalPages);
		System.out.println("Courses - "+ course);
		
	}
	
	@Test
	public void getsortedPages() {
		Pageable firstPage =  PageRequest.of(0, 2, Sort.by("credits"));
		Pageable secondPage = PageRequest.of(2,2,Sort.by("courseID"));
		
		List<Course> FirstCourse = courseRepo.findAll(firstPage).toList();
		
		List<Course> secondCourse = courseRepo.findAll(secondPage).toList();
		List<Course> SortedList = courseRepo.findAll(Sort.by("title"));
		
		System.out.println("First -->"+FirstCourse);
		System.out.println("Second -->"+secondCourse);
		System.out.println("Sorted --> "+SortedList);
		
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		
		Student student = Student.builder().email("me@gmail.com").firstName("me").lastName("Bacha").build();
		
		Teacher teacher = Teacher.builder().FirstName("Lex").LastName("Fridman").build();
		
		Course course = Course.builder().credits(12).title("AI").teacher(teacher).students(List.of(student)).
				build();
		//course.addStudents(student);
		
		courseRepo.save(course);
		
	}
}

