package com.gal;

import com.gal.api.TrainingController;
import com.gal.model.Training;
import com.gal.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest  : this will run the project and then you can use httpclient
@WebMvcTest(TrainingController.class)
public class TrainingControllerTest {

//    @Autowired
//    private DefaultMockMvcBuilder
//    defaultMockMvcBuilder;
   @MockitoBean
   TrainingService trainingService;
//@MockBean
//TrainingService trainingService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testFindById() throws Exception {
//        fail("Not yet implemented");
        Training t = new Training(
                101,
                LocalDate.of(2026,03,07),
                LocalDate.of (2026,04,10),
                "Mockito",
                "Unnati Bhardwaj"
        );
        when(trainingService.findById(101)).thenReturn(t);

        mockMvc.perform(get("/training/101")
                        .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.trainingId").value("101"))
                .andExpect(jsonPath("$.trainingId").value("101"))
                        .andDo(res->System.out.println(res.getResponse().getContentAsString()));

    }
}
