package com.aravind.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
//@Table(name = "emp_tbl")
public class Employee {

    @SuppressWarnings("deprecation")
	@Id
    @GeneratedValue(generator = "custom-generator")
    @GenericGenerator(name = "custom-generator", strategy = "com.aravind.generator.CustomIdGenerator")
    private String id;

    private String name;
    
    @CreationTimestamp
    @Column(name = "insertDate",updatable =false)
    private LocalDate insertDate;
    @UpdateTimestamp
    @Column(name = "updateDate",insertable = false)
    private LocalDate updateDate;
}
