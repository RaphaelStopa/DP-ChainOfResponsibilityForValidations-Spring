package com.example.chainOfResponsibility.entityName.impl;


import com.example.chainOfResponsibility.exception.ValidateFundException;
import com.example.chainOfResponsibility.interfaces.IValidator;
import com.example.chainOfResponsibility.request.ItemBatchRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("startValidate")
class ValidateOne implements IValidator<ItemBatchRequestDTO> {

	@Autowired
	@Qualifier("validateTwo")
	private IValidator<ItemBatchRequestDTO> validateTwo;


	@Override
	public void validate(ItemBatchRequestDTO fundRequestDTO) throws ValidateFundException {

//		String document = fundRequestDTO.getDocument();
//		String fieldName = "document";
//
//		if (Objects.isNull(document)) {
//			throw new ValidateFundException(new FieldError(fieldName, "CNPJ do fundo é de preenchimento obrigatório"));
//		}
//		if (Boolean.FALSE.equals(ValidateCNPJ.validate(document))) {
//			throw new ValidateFundException(new FieldError(fieldName, String.format("CNPJ %s inválido", document)));
//		}
//
//		Optional<Fund> optFund = fundRepository.findByDocument(document);
//		optFund.ifPresent(fund -> new ValidateFundException(new FieldError(fieldName,
//				String.format("CNPJ % já cadastrado na Plataforma como Fundo %s", fund.getDocument(), fund.getName()))));

	}

	@Override
	public IValidator<ItemBatchRequestDTO> next() {
		//It was wanted that saisse de list is enough for null here
		// If it is a matter of operation until reaching x point a while
		return validateTwo;
	}
}
