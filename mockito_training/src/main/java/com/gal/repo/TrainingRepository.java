package com.gal.repo;

import org.springframework.stereotype.Repository;

import com.gal.model.Training;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TrainingRepository
        extends JpaRepository<Training, Integer>
{

}
