package com.enviro.assessment.grad001.charlesmoswane.enviro_assessment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EnviroAssessmentApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Test get environmental data before file upload")
	public void testGetAllEnvironmentalDataEmpty() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/environmental/data"))
				.andExpect(status().isOk());
	}
}
