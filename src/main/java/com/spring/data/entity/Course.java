package com.spring.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class Course {

	@Id
	@SequenceGenerator(allocationSize = 1, sequenceName = "course_sequence",name = "course_sequence")
	@GeneratedValue(generator = "course_sequence",strategy = GenerationType.SEQUENCE)

	private long courseID;
	
	@Column(nullable = false, name="course_title")
	private String title;
	
	private int credits;
	
	@OneToOne(mappedBy = "course")
	private CourseMaterial courseMaterial;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
	private Teacher teacher;
	
}
