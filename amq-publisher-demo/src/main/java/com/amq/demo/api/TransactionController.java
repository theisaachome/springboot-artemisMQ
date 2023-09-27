package com.amq.demo.api;

import com.amq.demo.broker.Transaction;
import com.amq.demo.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody Transaction dto){
        transactionService.sendMessage(dto);
        return  new ResponseEntity<>("Sent :", HttpStatus.OK);
    }
}
