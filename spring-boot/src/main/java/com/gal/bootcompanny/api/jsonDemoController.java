package com.gal.bootcompanny.api;

import com.gal.bootcompanny.model.Department;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/json/")
public class jsonDemoController {
    @GetMapping("/department")
    public ResponseEntity<String> getDepartmentJson() {
        Department obj = new Department();
        obj.setId(65);
        obj.setName("Test Department");//
        obj.setManager_id(201);
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(obj);
//        return string;

        ResponseEntity.ok().body(string); //ok code 200
        ResponseEntity.status(HttpStatus.CREATED).body(string);
        ResponseEntity.status(HttpStatus.NO_CONTENT);
         return ResponseEntity.ok().header("content type","application/json").body(string);

//reflectionapi : getallproperties name getproperty value, json put

    }
}
