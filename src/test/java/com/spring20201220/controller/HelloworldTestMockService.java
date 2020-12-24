package com.spring20201220.controller;

import com.spring20201220.config.WebAppConfig;
import com.spring20201220.model.GreetingWord;
import com.spring20201220.service.GreetingService;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;

/**
 * Mock a service which is dependency of controller
 *
 */

@ExtendWith(SpringExtension.class)
//@ExtendWith({MockitoExtension.class})
@WebAppConfiguration
@ContextConfiguration(classes = {HelloworldAPITestConfig.class, WebAppConfig.class})
@ActiveProfiles("test") // will not import WebAppConfig.class configuration, since this is mock test
public class HelloworldTestMockService {
    @Autowired
    private WebApplicationContext wac;

    @Mock
    GreetingService mockGreetingService;

    @InjectMocks
    HelloworldAPI helloworldAPI;

    private MockMvc mvc;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
//        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        this.mvc =  MockMvcBuilders.standaloneSetup(helloworldAPI).build();
//        mockGreetingService = org.mockito.Mockito.mock(GreetingService.class);
        when(mockGreetingService.getGreetingWord("tony")).thenReturn(new GreetingWord("Hii ","tony"));
    }
    @Test
    public void greeting() throws Exception {
        GreetingWord hiiTony = mockGreetingService.getGreetingWord("tony");
        Assert.assertEquals(hiiTony.getGreetingStart(), "Hii ");

        ResultActions rs1 = this.mvc.perform(
                MockMvcRequestBuilders.get("/greeting?name=tony")
                        .contentType("application/json")
        );
        MvcResult result = rs1.andReturn();
        String body = result.getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(body);
        System.out.println("****"+body);
        Assert.assertEquals(jsonObject.get("greetingStart"), "Hii ");

    }
}
