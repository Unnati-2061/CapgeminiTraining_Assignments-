package com.gal.bootcompanny.dao;

import com.gal.bootcompanny.model.CabAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CabAllocationRepo extends JpaRepository<CabAllocation, Integer> {

    List<CabAllocation> findByTravelDate(LocalDate date);
}