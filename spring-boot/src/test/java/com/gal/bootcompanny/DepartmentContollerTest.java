package com.gal.bootcompanny;

import com.gal.bootcompanny.api.DepartmentController;
import com.gal.bootcompanny.model.Department;
import com.gal.bootcompanny.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
public class DepartmentContollerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService depService;

    @Test
    void testGetDepartment() throws Exception {

        Department department = new Department();
        department.setId(1);
        department.setName("HR");
        department.setManager_id(2234);


        when(depService.find(1)).thenReturn(department);


        mockMvc.perform(get("/department/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("HR"));

        // OPTIONAL: if exception handling exists
//        when(depService.find(2)).thenThrow(new RuntimeException("Not found"));
//
//        mockMvc.perform(get("/department/2")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
    }
}