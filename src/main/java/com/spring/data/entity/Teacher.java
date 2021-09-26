package com.spring.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
	@Id
	@SequenceGenerator(name = "teacher_id",sequenceName = "teacher_id")
	@GeneratedValue(generator ="teacher_id",strategy = GenerationType.SEQUENCE)
	private long teacherId;
	private String FirstName;
	private String LastName;
	
	/* Will add Many to one relationship in Course.
	 * @OneToMany(cascade = CascadeType.ALL,targetEntity = Course.class)
	 * 
	 * @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId") private
	 * List<Course> courses;
	 */

}
