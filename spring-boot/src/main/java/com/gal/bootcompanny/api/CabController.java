package com.gal.bootcompanny.api;
import com.gal.bootcompanny.model.CabAllocation;
import com.gal.bootcompanny.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    private CabService service;


    @PostMapping
    public CabAllocation allocate(@RequestBody CabAllocation cab){
        return service.allocateCab(cab);
    }

    @GetMapping("/{date}")
    public List<CabAllocation> getByDate(@PathVariable String date){
        return service.getByDate(LocalDate.parse(date));
    }
}