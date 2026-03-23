package com.gal.bootcompanny.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gal.bootcompanny.model.Department;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/json")
public class JsonDemoController {

    @GetMapping("/department")
    public ResponseEntity<String> getDepartmentJson() throws Exception {

        Department obj = new Department();
        obj.setId(65);
        obj.setName("Test Department");
        obj.setManager_id(201);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(obj);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(json);
    }
}