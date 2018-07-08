package com.n26.test.project.demo.statistics;

import com.n26.test.project.demo.repository.StatsRepo;
import com.n26.test.project.demo.transactions.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StatisticsTest {
    StatsRepo repo;
    Statistics statistics;

    @Before
    public void init(){
        repo = new StatsRepo();
        StatisticsService service = new StatisticsService(repo);
        statistics = new Statistics(service);
    }


    @Test
    public void addTransactionsPerSecond() throws InterruptedException {
        for(int i=1; i<=61; i++)
        {
            repo.addStats(System.currentTimeMillis(), i);
            Thread.sleep(1000);
        }

        assertTrue(statistics.get().getCount() == 60);
    }
}
