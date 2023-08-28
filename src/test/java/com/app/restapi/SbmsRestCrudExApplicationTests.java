package com.app.restapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc

class SbmsRestCrudExApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Save Test")
	public void testA() throws Exception
	{
		//a. Create mock request
		//EG.1
		MockHttpServletRequestBuilder request = 
				 MockMvcRequestBuilders
				 .post("/v1/api/student/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"stdId\":3,\"stdName\":\"Salim\",\"stdGen\":\"Male\",\"stdCourse\":\"Mechanical\",\"stdAdd\":\"SA 994554\"}");
		/*
		 * //Eg. 2 Delete operations MockHttpServletRequestBuilder req =
		 * MockMvcRequestBuilders.delete("/v1/api/student/delete/1"); //Ef .3 Fetch
		 * operarions MockHttpServletRequestBuilder req2 =
		 * MockMvcRequestBuilders.delete("/v1/api/student/all");
		 */
		
		// b. Execute request and read results 
		MvcResult result =   mockMvc.perform(request).andReturn();
		//c. Read response from results

		MockHttpServletResponse response =   result.getResponse();	
		
		//d. Assert results with expected values
		
		assertNotNull(response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());

		if(!response.getContentAsString().contains("created")) {
			fail("Looks student not created ");
		}
		
	}


}
