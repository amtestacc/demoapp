package com.n26.test.project.demo.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class StatisticsService {
    StatsStorage statsStorage;

    @Autowired
    public StatisticsService(StatsStorage statsStorage) {
        this.statsStorage = statsStorage;
    }

    Statistic getStatistics(){
        return statsStorage.getStats();
    }
}
