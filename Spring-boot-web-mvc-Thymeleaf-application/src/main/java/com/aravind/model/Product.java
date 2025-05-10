package com.aravind.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Product name should not be null")
    @Size(min = 1, message = "Product name must not be empty")
    private String prodName;

    @NotNull(message = "Price should be mandatory")
    @DecimalMin(value = "0.1", message = "Price must be greater than 0")
    private Double price;

    @NotNull(message = "Quantity should be mandatory")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
	@CreationTimestamp
	@Column(name = "insertTime",updatable = false)
	private LocalDateTime insertTime;
	@UpdateTimestamp
	@Column(name="updateTime",insertable = false)
	private LocalDateTime updateTime;

}
