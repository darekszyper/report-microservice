package com.example.report.service;

import com.example.report.entity.Trainer;
import com.example.report.repository.TrainerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class TrainerService {

    @Autowired
    private TrainerMapper trainerMapper;

    public Trainer createRandomTrainer() {
        // Generate random data for the new Trainer
        String trainerUsername = UUID.randomUUID().toString();
        String firstName = "FirstName" + new Random().nextInt(1000);
        String lastName = "LastName" + new Random().nextInt(1000);
        String traineeStatus = new Random().nextBoolean() ? "Active" : "Inactive";
        int years = new Random().nextInt(50);
        int months = new Random().nextInt(12);

        Trainer newTrainer = new Trainer(trainerUsername, firstName, lastName, traineeStatus, years, months);
        return newTrainer;
    }

    public void saveTrainer(Trainer trainer) {
        if (trainer != null) {
            trainerMapper.save(trainer);
        }
    }
}
