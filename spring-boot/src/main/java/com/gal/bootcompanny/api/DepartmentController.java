package com.gal.bootcompanny.api;

import com.gal.bootcompanny.model.Department;
import com.gal.bootcompanny.service.DepartmentService;
import jakarta.transaction.Transactional;
import org.apache.tomcat.jni.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

//@Controller
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService depService;

//    @ResponseBody
//    public String getDepartment() {
//        return depService.find(10).toString();
//    }

    @ResponseBody
    public List<String> getAllDepartment() {
        return depService
                .findAll()
                .stream()
                .map(Department::toString)
                .collect(Collectors.toList());
    }

    @GetMapping("/byname")
    public Department getDepartmentByName(@RequestParam("name") String name){
        Department department = depService.findByName(name);
        return department;
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    Department addDepartment(@RequestBody Department dept) {
        Department d = depService.addDepartment(dept);
        log.debug("controller returning " + d);
        return d;
    }
//    @RequestMapping(value = "(depid)" , method = RequestMethod.GET)
//    public ResponseEntity<Department> getDepartment (@PathVariable("depid") int deptid){
//        log.debug("request for epid " + deptid);
//        Department department = depService.find(deptid);
//        if(department == null){
//            return ResponseEntity.notFound();
//        }
//        ResponseEntity.status(HttpStatusCode.CREATED)
//    }
}
