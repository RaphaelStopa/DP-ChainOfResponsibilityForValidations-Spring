package com.example.chainOfResponsibility.entityName.impl;


import com.example.chainOfResponsibility.interfaces.IValidator;
import com.example.chainOfResponsibility.request.ItemBatchRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.chainOfResponsibility.response.BatchResponse.*;

import java.util.Objects;

@Service
@Qualifier("validateTwo")
class ValidateTwo implements IValidator<ItemBatchRequestDTO> {

	private static final String REGEX_MIN_TWO_WORDS = "^[a-zA-Z.]{2,} [a-zA-Z]{2,}$";
	

	@Autowired
	@Qualifier("validateFinal")
	private ValidateFinal validateFinal;

	@Override
	public void validate(ItemBatchRequestDTO value) throws ValidateExceptionImpl {

		if(Objects.isNull(value) || Objects.isNull(value.getName())){
			throw new ValidateExceptionImpl(new FieldError("name", "Nome do Fundo é de preenchimento obrigatório"));
		}

		if(!value.getName().matches(REGEX_MIN_TWO_WORDS)){
			throw new ValidateExceptionImpl(new FieldError("name", "Nome do Fundo / Razão Social inválido, digite o nome completo"));
		}

		if(value.getName().length() > 150){
			throw new ValidateExceptionImpl(new FieldError("name", "O campo \"name\" deve conter no máximo 150 caracteres"));
		}
	}

	@Override
	public IValidator<ItemBatchRequestDTO> next() {
		return validateFinal;
	}
}
