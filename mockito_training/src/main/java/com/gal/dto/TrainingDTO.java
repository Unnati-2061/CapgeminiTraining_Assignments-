package com.gal.dto;

public class TrainingDTO {

   private int trainingId;
   private String topic;

    public TrainingDTO(int trainingId, String topic) {
        this.trainingId = trainingId;
        this.topic = topic;
    }
    public int getTrainingId() {
        return trainingId;
    }
    public String getTopic() {
        return topic;
    }
}