package com.example.chainOfResponsibility.entityName.impl;


import com.example.chainOfResponsibility.entityName.RequestValidator;
import com.example.chainOfResponsibility.interfaces.IValidator;
import com.example.chainOfResponsibility.request.ItemBatchRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.chainOfResponsibility.response.BatchResponse.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestValidate implements RequestValidator {
	@Autowired
	@Qualifier("startValidate")
	private IValidator<ItemBatchRequestDTO> startValidator;

	@Override
	public List<BatchError> valid(ItemBatchRequestDTO request) {
		System.out.println(startValidator);

		IValidator<ItemBatchRequestDTO> nextValidator = startValidator;
		List<BatchError> errors = new ArrayList<>();
		var error = new BatchError(request.getDocument());
		while (nextValidator != null) {
			try {
				nextValidator.validate(request);
			} catch (ValidateExceptionImpl e) {
				error.getFieldErrors().add(e.getFieldError());
			}
			nextValidator = nextValidator.hasNext() ? nextValidator.next() : null;
		}
		errors.add(error);
		return errors.stream().collect(Collectors.toList());
	}

}
