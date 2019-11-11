package com.sandesh.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.sandesh.validator.PostalCodeConstraintValidator;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = PostalCodeConstraintValidator.class)
public @interface PostalCode {

	// default postal code
	public String value() default "SAN";
	
	// default message   -> can group related constraints
	public String message() default "Postal code should begin with SAN";
	
	// default groups
	public Class<?>[] groups() default {};
	
	// default payload  -> provide custom details about validation failure (severity level, error code etc)
	public Class<? extends Payload>[] payload() default {};
}
