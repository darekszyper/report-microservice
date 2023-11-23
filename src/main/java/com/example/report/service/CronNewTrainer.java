package com.example.report.service;

import com.example.report.entity.Trainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class CronNewTrainer {

    private static final Logger logger = LoggerFactory.getLogger(CronNewTrainer.class);

    @Autowired
    private TrainerService trainerService;

    @Scheduled(fixedRate = 20000) // Scheduling this method to run every 20000 milliseconds (20 seconds)
    public void scheduleTaskWithFixedRate() {
        Trainer newRandomTrainer = trainerService.createRandomTrainer();
        trainerService.saveTrainer(newRandomTrainer);
        logger.info("New trainer saved");
    }
}
