package com.example.chainOfResponsibility.interfaces;


import com.example.chainOfResponsibility.exception.ValidateException;

public interface IValidator<T> {

	IValidator<T> next();

	<E extends ValidateException> void validate(T value) throws E;

	default boolean hasNext() {
		return next() != null;
	}
}
