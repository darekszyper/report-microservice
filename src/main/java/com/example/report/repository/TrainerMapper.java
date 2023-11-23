package com.example.report.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.example.report.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainerMapper {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public TrainerMapper(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public List<Trainer> findByUsername(String trainerUsername) {
        Trainer hashKeyValues = new Trainer();
        hashKeyValues.setTrainerUsername(trainerUsername);
        DynamoDBQueryExpression<Trainer> queryExpression = new DynamoDBQueryExpression<Trainer>()
                .withHashKeyValues(hashKeyValues)
                .withConsistentRead(false);
        return dynamoDBMapper.query(Trainer.class, queryExpression);
    }

    public List<Trainer> findAll() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        return dynamoDBMapper.scan(Trainer.class, scanExpression);
    }

    public Trainer save(Trainer trainer) {
        dynamoDBMapper.save(trainer);
        return trainer;
    }
}
