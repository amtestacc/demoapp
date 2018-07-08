package com.n26.test.project.demo.transactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transactions")
public class Transactions {
    Logger logger = LoggerFactory.getLogger(getClass());
    TransactionsStorageService service;

    @Autowired
    public Transactions(TransactionsStorageService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> add(@RequestBody Transaction transaction){
        logger.info("adding transaction");
        logger.debug("adding transaction : [{}]", transaction);
        try {
            if(service.addTransaction(transaction))
                return ResponseEntity.ok().build();
            else return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }

    }
}
