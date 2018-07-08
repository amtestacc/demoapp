package com.n26.test.project.demo.repository;

import com.n26.test.project.demo.transactions.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionsRepoObserver implements TransactionsObserver{
    StatsRepo statsRepo;

    @Autowired
    public TransactionsRepoObserver(StatsRepo statsRepo) {
        this.statsRepo = statsRepo;
    }

    @Override
    public void update(Transaction trx) {
        statsRepo.addStats(trx.getTime(), trx.getAmount());
    }
}
