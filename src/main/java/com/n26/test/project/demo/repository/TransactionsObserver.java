package com.n26.test.project.demo.repository;

import com.n26.test.project.demo.transactions.Transaction;

public interface TransactionsObserver {
    void update(Transaction trx);
}
