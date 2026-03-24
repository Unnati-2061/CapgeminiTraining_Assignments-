package com.gal.service;

import java.util.List;

import com.gal.model.Training;

public interface TrainingService {
    List<Training> findByTopic(String topic);

    Training findById(int trainingId);

    Training addTraining(Training training);

    Training updateTraining(Training training);

    boolean deleteTraining(int trainingId);
}
