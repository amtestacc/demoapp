package com.n26.test.project.demo.statistics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistics")
public class Statistics {
    Logger logger = LoggerFactory.getLogger(getClass());
    StatisticsService service;

    @Autowired
    public Statistics(StatisticsService service) {
        this.service = service;
    }

    @GetMapping
    public Statistic get(){
        logger.info("getting statistics");
        Statistic stats = service.getStatistics();
        logger.debug("returning stats : {[]}", stats);
        return stats;
    }
}
