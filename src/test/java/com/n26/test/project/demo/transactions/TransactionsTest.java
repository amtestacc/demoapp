package com.n26.test.project.demo.transactions;

import com.n26.test.project.demo.repository.StatsRepo;
import com.n26.test.project.demo.repository.TransactionsRepo;
import com.n26.test.project.demo.repository.TransactionsRepoObserver;
import com.n26.test.project.demo.statistics.Statistics;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Date;
import java.util.zip.DataFormatException;

import static org.junit.Assert.assertTrue;

public class TransactionsTest {
    Transactions transactions;

    @Before
    public void init(){
        StatsRepo statsRepo = new StatsRepo();
        TransactionsRepoObserver transactionsRepoObserver = new TransactionsRepoObserver(statsRepo);
        TransactionsRepo transactionsRepo = new TransactionsRepo(transactionsRepoObserver);
        TransactionsStorageService transactionsStorageService = new TransactionsStorageService(transactionsRepo);
        transactions = new Transactions(transactionsStorageService);
    }

    @Test
    public void addInFutureTest(){
        long time = System.currentTimeMillis() + 1000;
        Transaction trx = new Transaction(time, 2.0);
        ResponseEntity response = transactions.add(trx);
        assertTrue(response.getStatusCode().is2xxSuccessful());

    }

    @Test
    public void addInPastTest(){
        long time = System.currentTimeMillis() - 70000;
        Transaction trx = new Transaction(time, 2.0);
        ResponseEntity response = transactions.add(trx);
        assertTrue(response.getStatusCode().is2xxSuccessful());

    }

}
