package com.gal.bootcompanny.api;

import com.gal.bootcompanny.model.Department;
import com.gal.bootcompanny.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService depService;

    @GetMapping
    public List<String> getAllDepartment() {
        return depService.findAll()
                .stream()
                .map(Department::toString)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        log.debug("Fetching department with id: " + id);
        return depService.find(id);
    }

    @GetMapping("/byname")
    public Department getDepartmentByName(@RequestParam("name") String name) {
        return depService.findByName(name);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Department addDepartment(@RequestBody Department dept) {
        Department d = depService.addDepartment(dept);
        log.debug("controller returning " + d);
        return d;
    }
}

//