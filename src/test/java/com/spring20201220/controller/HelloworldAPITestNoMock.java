package com.spring20201220.controller;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Without Mock a service which is dependency of controller
 *
 */

@ExtendWith(SpringExtension.class)
//@ExtendWith({MockitoExtension.class})
@WebAppConfiguration
@ContextConfiguration(classes = {HelloworldAPITestConfig.class})
public class HelloworldAPITestNoMock {
    @Autowired
    private WebApplicationContext wac;

//    @Mock
//    GreetingService mockGreetingService;
    private MockMvc mvc;

    @BeforeEach
    public void setup() throws Exception {
//        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

//        mockGreetingService = org.mockito.Mockito.mock(GreetingService.class);
//        when(mockGreetingService.getGreetingWord("tony")).thenReturn(new GreetingWord("Hii ","tony"));
    }
    @Test
    public void greeting() throws Exception {
//        GreetingWord hiiTony = mockGreetingService.getGreetingWord("tony");
//        Assert.assertEquals(hiiTony.getGreetingStart(), "Hii ");

        ResultActions rs1 = this.mvc.perform(
                MockMvcRequestBuilders.get("/greeting?name=tony")
                                    .contentType("application/json")
        );
        MvcResult result = rs1.andReturn();
        String body = result.getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(body);
        System.out.println("****"+body);
        Assert.assertEquals(jsonObject.get("greetingStart"), "Hi ");

    }
}
