package com.spring.data.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.entity.Guardian;
import com.spring.data.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepo;
	
	
	/*
	 * @Test public void saveStudent() {
	 * 
	 * Student student =
	 * Student.builder().email("nisaar2@gmail.com").firstName("Nisaaar")
	 * .lastName("Agharia").build(); // guardianEmail("gar@gmail.com") // //
	 * .guardianMobile("9004738110") // .guardianName("GARD1"). build();
	 * 
	 * // studentRepo.save(student);
	 * 
	 * 
	 * }
	 */
	 
	
	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian = Guardian.builder().email("Asgarali12345@gmail.com").name("Asgarali").mobile("00000000").build();
		
		Student student = Student.builder().firstName("Asgarali").lastName("Agharia").email("Asgarali@gmail.com").gaurdian(guardian).build();
		
	//	studentRepo.save(student);
	}
	
	@Test
	public void printAllStudent() {
		List <Student> studentList = studentRepo.findAll();
		
		System.out.println("List of Students" + studentList);
		
		
	}
	
	@Test
	public void findName() {
		
		List<Student> student=studentRepo.findByfirstName("Hasnain");		
		System.out.println("Find Name "+ student);
	}
	
	@Test
	public void findBystudentId() {
		
		Student student=studentRepo.findBystudentId(4);		
		System.out.println("Find Name "+ student);
	}
	
	@Test
	public void countBystudent() {
		
		Student student=studentRepo.findBystudentId(4);		
		System.out.println("Find Name "+ student);
	}
	
	@Test
	public void firstNameLike() {
		
		List<Student> student=studentRepo.findByfirstNameLike("%a%");		
		System.out.println("Pattern "+ student);
	}
	
	@Test
	public void CountfirstNameLike() {
		
		long count=studentRepo.countByfirstNameLike("%a%");		
		System.out.println("Pattern "+ count);
	}
	
	@Test
	public void CountNotLike() {
		
		long count=studentRepo.countByfirstNameNotLike("%a%");		
		System.out.println("Not found Pattern "+ count);
	}
	
	@Test
	public void CountDistinctfirstNameLike() {
		
		long count=studentRepo.countDistinctByfirstNameLike("%a%");		
		System.out.println("Pattern "+ count);
	}
	
	
	@Test
	public void FindGuardianName() {
		
		long count=studentRepo.countBygaurdianName("GARD1");		
		System.out.println("Guardian Name "+ count);
	}
	
	@Test
	public void CountGuardianNumber() {
		
		List<Student> student=studentRepo.findBygaurdianMobileGreaterThan("9004738110");		
		System.out.println("Count Student Names "+ student);
	}
	
	@Test
	public void findBygaurdianMobileGreaterThan() {
		
		long student=studentRepo.countBygaurdianMobileGreaterThan("9004738110");		
		System.out.println("Count Student Names "+ student);
	}
	
	@Test
	public void findNameContaining() {
		
		List<Student> student=studentRepo.findByfirstNameContaining("ni");		
		System.out.println("Similar  Name "+ student);
	}
	
	@Test
	public void findAllName() {
		
		String student=studentRepo.findByAllName("Hasnain");		
		System.out.println("Similar  Name "+ student);
	}
	
	@Test
	public void findGuardain() {
		
		Guardian gaurd=studentRepo.findByAllGaurdian("Hasnain");		
		System.out.println("Similar  Name "+ gaurd);
	}
	@Test
	public void findGuardainByName() {
		
		String gaurd=studentRepo.findByAllGaurdianName("Hasnain");		
		System.out.println("Similar  Name "+ gaurd);
	}
	
	@Test
	public void findGuardainNativeQuery() {
		
		Student st=studentRepo.findByAllGaurdianNativeQuery("");		
		System.out.println("Similar  Name "+ st);
	}
	
	@Test
	public void findByStudentNativeQuery() {
		
		Student st=studentRepo.findByStudentNativeQuery(5);		
		System.out.println("Similar  Name "+ st);
	}
	@Test
	public void findByAllNativeQuery() {
		
		List<Student> st=studentRepo.findByAllNativeQuery("GARD1","test@gmail.com");		
		System.out.println("Similar  Name "+ st);
	}
}
