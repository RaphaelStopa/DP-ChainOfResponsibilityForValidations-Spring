package com.example.chainOfResponsibility.entityName.impl;


import com.example.chainOfResponsibility.exception.ValidateException;
import com.example.chainOfResponsibility.response.BatchResponse.*;
import lombok.Getter;

@Getter
public class ValidateExceptionImpl extends ValidateException {

	private final FieldError fieldError;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3374212508280466744L;

	public ValidateExceptionImpl(String message) {
		super(message);
		this.fieldError = new FieldError(null, message);
	}

	public ValidateExceptionImpl(FieldError fieldError) {
		super(fieldError == null ? "" :   fieldError.getMessage());
		this.fieldError = fieldError;
	}
}
