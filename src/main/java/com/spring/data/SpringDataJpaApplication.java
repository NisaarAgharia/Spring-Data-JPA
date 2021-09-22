package com.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.data.entity.Guardian;
import com.spring.data.entity.Student;
import com.spring.data.repo.StudentDataService;
import com.spring.data.repo.StudentRepository;


@ComponentScan("com.spring")
//@EnableJpaRepositories(basePackages = "com.spring")
@SpringBootApplication
public class SpringDataJpaApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
		
//		Guardian guardian = Guardian.builder().email("Asgarali12345@gmail.com").name("Asgarali").mobile("00000000").build();
//		Student student = Student.builder().email("raziya2@gmail.com").firstName("raziya")
//				.lastName(" ").
//				gaurdian(guardian).
//				build();
//		
		//StudentDataService student1 = new StudentDataService();
		//student1.SaveStudentInfo(student);
		
	//AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(SpringDataJpaApplication.class);
	//StudentRepository studentRepo = acac.getBean(Stude ntRepository.class);
		
		
	}

}
