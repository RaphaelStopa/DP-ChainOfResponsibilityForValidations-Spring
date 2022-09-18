package com.example.chainOfResponsibility.service;

import com.example.chainOfResponsibility.entityName.RequestValidator;
import com.example.chainOfResponsibility.request.ItemBatchRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Validated
public class BatchService {

    @Autowired
    private RequestValidator validator;

    public void saveAll(ItemBatchRequestDTO itemBatchRequestDTO) {
         var nha =validator.valid(itemBatchRequestDTO);
        System.out.println(nha);
    }
}
