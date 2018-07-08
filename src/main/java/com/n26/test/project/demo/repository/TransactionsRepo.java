package com.n26.test.project.demo.repository;

import com.n26.test.project.demo.transactions.Storage;
import com.n26.test.project.demo.transactions.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;


@Repository
public class TransactionsRepo implements Storage{
    Logger logger = LoggerFactory.getLogger(getClass());
    TransactionsObserver transactionsObserver;
    private List<Transaction> transactions;

    @Autowired
    public TransactionsRepo(TransactionsObserver transactionsObserver) {
        this.transactionsObserver = transactionsObserver;
        this.transactions = new LinkedList<>();
    }

    @Override
    public void add(Transaction trx) throws Exception {
        logger.info("adding transaction");
        logger.debug("adding transaction : [{}]", trx);
        transactions.add(trx);
        transactionsObserver.update(trx);
        if(transactions.size() > 1000)
            transactions.clear();
    }
}
