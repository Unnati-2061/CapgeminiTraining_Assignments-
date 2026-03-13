package com.gal.bootcompanny.api;

import com.gal.bootcompanny.model.Department;
import com.gal.bootcompanny.service.DepartmentService;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/department")
    @ResponseBody
    public String getDepartment() {
        return departmentService.find(10).toString();
    }

    @RequestMapping("/departmentAll")
    @ResponseBody
    public List<String> getAllDepartment() {
        return departmentService
                .findAll()
                .stream()
                .map(Department::toString)
                .collect(Collectors.toList());
    }

}
