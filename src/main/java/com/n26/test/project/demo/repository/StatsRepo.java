package com.n26.test.project.demo.repository;

import com.n26.test.project.demo.statistics.Statistic;
import com.n26.test.project.demo.statistics.StatsStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class StatsRepo implements StatsStorage{
    Logger logger = LoggerFactory.getLogger(getClass());
    private Map<Long, PartialStatistic> stats = new ConcurrentHashMap<>();

    @Override
    public Statistic getStats() {
        logger.info("computing statistiscs");
        long currentTime = System.currentTimeMillis()/1000;

        stats.keySet().stream().filter(p -> currentTime - p > 60).forEach( p -> stats.remove(p));
        PartialStatistic aggregator =  stats.values().stream().reduce((s1 , s2) -> new PartialStatistic(s1.getSum() + s2.getSum(),
                 Math.min(s1.getMin(), s2.getMin()),
                Math.max(s1.getMax(), s2.getMax()), s1.getCount() + s2.getCount())).get();
        Statistic result = new Statistic(aggregator.getSum(), aggregator.getSum()/aggregator.getCount(), aggregator.getMin(),
                aggregator.getMax(), aggregator.getCount());
        logger.debug("current stats : [{}]", result);
        return result;
    }

    public synchronized boolean addStats(long timestamp, double amount) {
        logger.info("adding stats");
        logger.info("adding stats : timestamp : [{}] , amount : [{}] ", timestamp, amount);
        long key = timestamp / 1000;
        if(stats.containsKey(key)){
            PartialStatistic stat = stats.get(key);
            stats.put(key, new PartialStatistic(stat.getSum() + amount, Math.min(stat.getMin(), amount),
                    Math.max(stat.getMax(), amount), stat.getCount()+1));
        }else{
            stats.put(key, new PartialStatistic(amount, amount, amount,1));
        }

        return  true;
    }
}
