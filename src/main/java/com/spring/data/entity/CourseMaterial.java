package com.spring.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
	@Id
	@SequenceGenerator(name = "course_material_sequence",sequenceName = "course_material_sequence",allocationSize = 1)
	@GeneratedValue(generator = "course_material_sequence",strategy = GenerationType.SEQUENCE)
	private Long courseMaterialId;
	
	@Column(name="material_url",nullable = false)
	private String url;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(
			name = "course_id",
			referencedColumnName = "courseID"
		)
	private Course course;
}
