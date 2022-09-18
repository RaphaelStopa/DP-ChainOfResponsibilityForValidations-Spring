package com.example.chainOfResponsibility.entityName;


import com.example.chainOfResponsibility.request.ItemBatchRequestDTO;
import com.example.chainOfResponsibility.response.BatchResponse.*;

import java.util.List;

public interface RequestValidator {

	List<BatchError> valid(ItemBatchRequestDTO fundRequest);
}
