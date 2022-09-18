package com.example.chainOfResponsibility.exception;


import com.example.chainOfResponsibility.response.BatchResponse.*;
import lombok.Getter;

@Getter
public class ValidateFundException extends ValidateException {

	private final FieldError fieldError;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3374212508280466744L;

	public ValidateFundException(String message) {
		super(message);
		this.fieldError = new FieldError(null, message);
	}

	public ValidateFundException(FieldError fieldError) {
		super(fieldError == null ? "" :   fieldError.getMessage());
		this.fieldError = fieldError;
	}

}
