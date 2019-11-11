package com.sandesh.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sandesh.annotation.PostalCode;

public class PostalCodeConstraintValidator implements ConstraintValidator<PostalCode, String> {
	
	private String postalPrefix;

	@Override
	public void initialize(PostalCode thePostalCode) {
		postalPrefix = thePostalCode.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value != null) return value.startsWith(postalPrefix);
		return false;
	}

}
