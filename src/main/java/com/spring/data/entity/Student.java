package com.spring.data.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbl_student",uniqueConstraints = @UniqueConstraint(name="emailid_unique",columnNames = {"email_address","guardian_mobile"})
)
public class Student {

	@Id
	@Column(name="student_id")
	@SequenceGenerator(
			name = "student_sequence",
			initialValue = 1,
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(generator = "student_sequence",strategy = GenerationType.SEQUENCE)
	private long studentId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(nullable = true)
	private String lastName;
	
	@Column(name="email_address",nullable = false)
	private String email;
	
	@Embedded
	private Guardian gaurdian;
	
}
