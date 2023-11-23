package com.example.report.controller;

import com.example.report.entity.Trainer;
import com.example.report.repository.TrainerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerMapper trainerMapper;

    @Autowired
    public TrainerController(TrainerMapper trainerMapper) {
        this.trainerMapper = trainerMapper;
    }

    @PostMapping
    public Trainer createTrainer(@RequestBody Trainer trainer) {
        return trainerMapper.save(trainer);
    }

    @GetMapping("/{username}")
    public List<Trainer> getTrainersByUsername(@PathVariable String username) {
        return trainerMapper.findByUsername(username);
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return trainerMapper.findAll();
    }
}
