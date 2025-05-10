package com.aravind.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SignUp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message ="name should be mandatory..")
	private String name;
	@Email
	@NotBlank(message ="email should be mandatory..")
	private String email;
	@NotBlank(message ="pwd should be mandatory..")
	@Size(min=6,max=8,message ="pwd should be in 6 to 8 range")
	private String pwd;
	@CreationTimestamp
	@Column(name = "insertDate",updatable = false)
	private LocalDate insertDate;
	@UpdateTimestamp
	@Column(name="updateDate",insertable = false)
	private LocalDate updateDate;
}
