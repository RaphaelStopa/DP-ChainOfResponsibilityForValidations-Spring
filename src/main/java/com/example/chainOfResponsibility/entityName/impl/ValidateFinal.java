package com.example.chainOfResponsibility.entityName.impl;


import com.example.chainOfResponsibility.interfaces.IValidator;
import com.example.chainOfResponsibility.request.ItemBatchRequestDTO;
import com.example.chainOfResponsibility.response.BatchResponse.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Qualifier("validateFinal")
class ValidateFinal implements IValidator<ItemBatchRequestDTO> {

	private static final String REGEX_MIN_TWO_WORDS = "^[a-zA-Z.]{2,} [a-zA-Z]{2,}$";


	@Override
	public void validate(ItemBatchRequestDTO value) throws ValidateExceptionImpl {
		validateNickname(value.getNickname());
	}

	private void validateNickname(String nickname) {
		if(Objects.isNull(nickname)){
			throw new ValidateExceptionImpl(new FieldError("nickname", "Apelido é de preenchimento obrigatório"));
		}

		if(!nickname.matches(REGEX_MIN_TWO_WORDS)){
			throw new ValidateExceptionImpl(new FieldError("nickname", String.format("Apelido %s inválido", nickname)));
		}

		if(nickname.length() > 40){
			throw new ValidateExceptionImpl(new FieldError("nickname", "O campo \"nickname\" deve conter no máximo 40 caracteres"));
		}
	}

	@Override
	public IValidator<ItemBatchRequestDTO> next() {
		return null;
	}
}
