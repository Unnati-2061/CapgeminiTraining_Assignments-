package com.gal.bootcompanny.service;

import com.gal.bootcompanny.dao.CabAllocationRepo;
import com.gal.bootcompanny.model.CabAllocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CabServiceImpl implements CabService {

    @Autowired
    private CabAllocationRepo repo;

    @Override
    public CabAllocation allocateCab(CabAllocation cab) {
        cab.setId(0);
        return repo.save(cab);
    }

    @Override
    public List<CabAllocation> getByDate(LocalDate date) {
        return repo.findByTravelDate(date);
    }
}