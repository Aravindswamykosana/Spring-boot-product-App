package com.aravind.generator;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {

	 @Override
	    public Serializable generate(SharedSessionContractImplementor session, Object object) {
	        String prefix = "AR_";
	        try {
	            Integer count = ((Number) session
	                    .createNativeQuery("SELECT COUNT(id) FROM employee")
	                    .getSingleResult()).intValue();

	            return prefix + (count + 1);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to generate AR ID", e);
	        }
	    }
}
