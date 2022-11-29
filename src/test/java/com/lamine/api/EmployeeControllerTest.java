package com.lamine.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.lamine.controller.EmployeeController;

// @WebMvcTest(controllers = EmployeeController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MockBean mockBean;

    /**
     * @throws Exception
     */
    @Test
    public void testGetEmployees() throws Exception {
        // mockMvc.perform(get("/employees"))
        // .andExpect(status().isOk())
        // .andExpect(jsonPath("$[0].firstName", is("Laurent")));
    }

}
