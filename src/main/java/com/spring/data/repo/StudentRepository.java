package com.spring.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.data.entity.Guardian;
import com.spring.data.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	public List<Student> findByfirstName(String name);
	
	public Student findBystudentId(long id);
	
	public List<Student> findByfirstNameLike(String pattern);
	
	public long countByfirstNameLike(String pattern);
	public long countByfirstNameNotLike(String pattern);
	
	public long countDistinctByfirstNameLike(String pattern);
	public List<Student> findBygaurdianName(String name);
	public long countBygaurdianName(String name);
	public List<Student> findBygaurdianMobileGreaterThan(String number);
	public long countBygaurdianMobileGreaterThan(String number);
	public List<Student> findByfirstNameContaining(String name);
	
	@Query("SELECT email FROM Student s where s.firstName= ?1")
//	@Query("select s from Student s where s.firstName = ?1")
	public String findByAllName(String firstName);
//	
	@Query("SELECT studentId FROM Student")
	public List<Student> findAllByName(String name);
	
	@Query("SELECT gaurdian FROM Student s where s.firstName= ?1")
	public Guardian findByAllGaurdian(String firstName);
	
	@Query("SELECT gaurdian.name FROM Student s where s.firstName=:firstName")
	public String findByAllGaurdianName(String firstName);
	
	@Query(nativeQuery = true,value="SELECT * FROM tbl_student s where student_id=5")
	public Student findByAllGaurdianNativeQuery(String s);
	
	@Query(nativeQuery = true,value="SELECT * FROM tbl_student s where student_id= :studentID")
	public Student findByStudentNativeQuery(long studentID);
	
	@Query(nativeQuery = true,value="SELECT * FROM tbl_student s where guardian_name= :GuardName AND guardian_email= :GuardEmail")
	public List<Student> findByAllNativeQuery(@Param("GuardName")String Name, @Param("GuardEmail")String Email);
}
