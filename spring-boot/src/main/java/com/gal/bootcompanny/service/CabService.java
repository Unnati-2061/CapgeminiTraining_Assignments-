package com.gal.bootcompanny.service;

import com.gal.bootcompanny.model.CabAllocation;

import java.time.LocalDate;
import java.util.List;

public interface CabService {
    CabAllocation allocateCab(CabAllocation cab);
    List<CabAllocation> getByDate(LocalDate date);
}