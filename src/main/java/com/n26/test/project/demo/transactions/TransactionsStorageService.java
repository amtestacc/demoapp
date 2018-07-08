package com.n26.test.project.demo.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class TransactionsStorageService {

    Storage storage;

    @Autowired
    public TransactionsStorageService(Storage storage) {
        this.storage = storage;
    }

    boolean addTransaction(Transaction trx) throws Exception {
        if(System.currentTimeMillis() - trx.getTime() > 60000)
            return false;
        storage.add(trx);
        return true;
    }

}
