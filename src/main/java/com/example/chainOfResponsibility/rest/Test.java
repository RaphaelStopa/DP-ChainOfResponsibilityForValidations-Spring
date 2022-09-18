package com.example.chainOfResponsibility.rest;

import com.example.chainOfResponsibility.request.ItemBatchRequestDTO;
import com.example.chainOfResponsibility.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Test{

    private final BatchService service;

    @GetMapping
    public ResponseEntity<String> test(@RequestBody ItemBatchRequestDTO itemBatchRequestDTO){
        //send this:
//        {
//            "document": "1111",
//                "name": "adsf",
//                "nickname": "asdfsd"
//        }
//
        service.saveAll(itemBatchRequestDTO);
        return ResponseEntity.ok("work");
    }
}
