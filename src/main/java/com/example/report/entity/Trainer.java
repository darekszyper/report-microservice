package com.example.report.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "Trainers")
public class Trainer {

    @DynamoDBHashKey(attributeName = "TrainerUsername")
    private String trainerUsername;

    @DynamoDBRangeKey(attributeName = "TraineeStatus")
    private String traineeStatus;

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "TrainerName-Index", attributeName = "TrainerFirstName")
    private String firstName;

    @DynamoDBIndexRangeKey(globalSecondaryIndexName = "TrainerName-Index", attributeName = "TrainerLastName")
    private String lastName;

    @DynamoDBAttribute(attributeName = "Years")
    private int years;

    @DynamoDBAttribute(attributeName = "Months")
    private int months;

    public String getTrainerUsername() {
        return trainerUsername;
    }

    public void setTrainerUsername(String trainerUsername) {
        this.trainerUsername = trainerUsername;
    }

    public String getTraineeStatus() {
        return traineeStatus;
    }

    public void setTraineeStatus(String traineeStatus) {
        this.traineeStatus = traineeStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    // Constructor...
    public Trainer() {
    }

    public Trainer(String trainerUsername, String firstName, String lastName, String traineeStatus, int years, int months) {
        this.trainerUsername = trainerUsername;
        this.firstName = firstName;
        this.lastName = lastName;
        this.traineeStatus = traineeStatus;
        this.years = years;
        this.months = months;
    }
}
