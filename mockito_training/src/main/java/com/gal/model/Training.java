package com.gal.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Training {
    @Id
    @GeneratedValue
    @Column(name = "training_id")
    private int trainingId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "topic")
    private String topic;

    @Column(name = "trainer_name")
    private String trainerName;

    public Training() {}

   public Training(
           int trainingId,
           LocalDate startDate,
           LocalDate endDate,
           String topic, String trainerName
   ){
        this.trainingId = trainingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.topic = topic;
        this.trainerName = trainerName;
   }
    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
}

