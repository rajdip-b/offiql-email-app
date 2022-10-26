package com.offiql.emailapp;

import com.offiql.emailapp.entity.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OffiqlEmailAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	void testSaveUser() throws Exception {
		mockMvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"firstName\":\"John\", \"lastName\":\"Doe\", \"email\":\"johndoe@email.com\", \"phoneNumber\":\"1234567890\"}"))
				.andDo(result -> System.out.println(result.getResponse().getContentAsString()))
				.andExpect(status().isOk());
	}

	@Test
	@Order(2)
	void testGetAllUsers() throws Exception {
		mockMvc.perform(get("/user")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(result -> System.out.println(result.getResponse().getContentAsString()))
				.andExpect(status().isOk());
	}

	@Test
	@Order(3)
	void testGetUserById() throws Exception {
		mockMvc.perform(get("/user/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(result -> System.out.println(result.getResponse().getContentAsString()))
				.andExpect(status().isOk());
	}

	@Test
	@Order(4)
	void testPostEmail() throws Exception {
		mockMvc.perform(post("/user")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"firstName\":\"John\", \"lastName\":\"Doe\", \"email\":\"johndoe@email.com\", \"phoneNumber\":\"1234567890\"}"))
				.andDo(result -> System.out.println(result.getResponse().getContentAsString()))
				.andExpect(status().isOk());
		mockMvc.perform(post("/email/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"fromEmail\":\"johndoe@gmail.com\", \"subject\":\"Test Subject\", \"body\":\"Test Body\", \"toEmail\":\"abc@gmail.com\"}"))
				.andDo(result -> System.out.println(result.getResponse().getContentAsString()))
				.andExpect(status().isOk());
	}

	@Test
	@Order(5)
	void testGetEmailCountByUserId() throws Exception {
		mockMvc.perform(get("/email/count?userId=1")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(result -> System.out.println(result.getResponse().getContentAsString()))
				.andExpect(status().isOk());
	}

}
