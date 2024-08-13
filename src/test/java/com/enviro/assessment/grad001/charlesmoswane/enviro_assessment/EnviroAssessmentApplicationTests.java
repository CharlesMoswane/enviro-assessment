package com.enviro.assessment.grad001.charlesmoswane.enviro_assessment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class EnviroAssessmentApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAllEnvironmentalData() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/environmentalData"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$._embedded.environmentalData").exists());
	}

}
