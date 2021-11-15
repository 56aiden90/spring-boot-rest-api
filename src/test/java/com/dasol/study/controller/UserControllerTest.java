package com.dasol.study.controller;

import com.dasol.study.entity.User;
import com.dasol.study.service.implementation.UserServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(UserController.class) // You can use either WebMvcTest annotation or SpringBootTest + AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserServiceImp userServiceImp;

    @BeforeEach
    void setup() {
    }

    @AfterEach
    void reset() {
    }

    @Test
    void create() throws Exception {
        User user = new User("name", "email");
        String userJson = this.objectMapper.writeValueAsString(user);
        mockMvc.perform(post("/user")
                        .content(userJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(userJson))
                .andDo(print());
    }

    @Test
    void find() throws Exception {
        User user = new User("name", "email");
        String userJson = this.objectMapper.writeValueAsString(user);
        this.userServiceImp.create(user);

        this.mockMvc.perform(
                        get("/user/" + user.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk()
                ).andExpect(content().string(userJson))
                .andDo(print());
    }
}