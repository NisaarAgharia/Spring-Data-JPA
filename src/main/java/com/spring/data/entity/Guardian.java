package com.spring.data.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
	@AttributeOverride( name= "name", column=@Column(name="guardian_name")),
	@AttributeOverride( name= "email", column=@Column(name="guardian_mobile")),
	@AttributeOverride( name= "mobile", column=@Column(name="guardian_email")
			)
})
public class Guardian {
	
	
	private String name;
	private String email;
	private String mobile;

}
