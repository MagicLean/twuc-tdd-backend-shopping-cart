package com.thoughtworks.capability.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.WebApplicationTest;
import com.thoughtworks.capability.domain.Example;
import com.thoughtworks.capability.service.ExampleService;
import com.thoughtworks.capability.web.dto.CreateExampleRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class ExampleControllerTest extends WebApplicationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    public ExampleService exampleService;

    @Test
    public void shouldGetExampleByIdSuccessWhenExampleIsExist() throws Exception {
        Long exampleId = 100L;
        when(exampleService.findExampleById(exampleId)).thenReturn(Example.builder().id(exampleId).build());

        mvc.perform(MockMvcRequestBuilders
            .get("/examples/" + exampleId)
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(100));
    }

    @Test
    public void shouldCreateExampleSuccess() throws Exception {
        CreateExampleRequest request = new CreateExampleRequest("content");
        when(exampleService.createExample(any(Example.class))).thenReturn(Example.builder().id(1L).content("content").build());

        mvc.perform(MockMvcRequestBuilders
            .post("/examples")
            .content(new ObjectMapper().writeValueAsString(request))
            .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andDo(print())
            .andExpect(status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

}
