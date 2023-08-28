package com.app.restapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class SbmsRestCrudExApplicationTests {

	@Autowired
	private MockMvc mockMvc; // COntainer Reerence

	@Test
	@DisplayName("Student # Save Test")
	@Order(1)
	public void testSaveStudent() throws Exception {
		// a. Create mock request
		// EG.1
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/v1/api/student/save")
				.contentType(MediaType.APPLICATION_JSON).content(
						"{\"stdId\":3,\"stdName\":\"Salim\",\"stdGen\":\"Male\",\"stdCourse\":\"Mechanical\",\"stdAdd\":\"SA 994554\"}");
		/*
		 * //Eg. 2 Delete operations MockHttpServletRequestBuilder req =
		 * MockMvcRequestBuilders.delete("/v1/api/student/delete/1"); //Ef .3 Fetch
		 * operarions MockHttpServletRequestBuilder req2 =
		 * MockMvcRequestBuilders.delete("/v1/api/student/all");
		 */

		// b. Execute request and read results
		MvcResult result = mockMvc.perform(request).andReturn();
		// c. Read response from results

		MockHttpServletResponse response = result.getResponse();

		// d. Assert results with expected values

		assertNotNull(response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());

		if (!response.getContentAsString().contains("created")) {
			fail("Looks student not created ");
		}

	}

	@Test
	@DisplayName("Student # Get all test")
	@Order(2)
	public void testGetStudents() throws Exception {
		// 1
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/v1/api/student/all")
				.contentType(MediaType.APPLICATION_JSON);
		// 2
		MvcResult result = mockMvc.perform(req).andReturn();
		// 3
		MockHttpServletResponse response = result.getResponse();
		// 4
		assertNotNull(response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	@DisplayName("Student  # Fetch one student")
	@Order(3)
	public void testFetchOneStudent() throws Exception {

		// 1
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/v1/api/student/find/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON);
		// 2
		MvcResult result = mockMvc.perform(req).andReturn();
		// 3
		MockHttpServletResponse response = result.getResponse();
		// 4
		assertNotNull(response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());

		assertEquals("application/json", response.getContentType());
		if (!response.getContentAsString().contains("Sachin")) {
			fail("Looks student data not exists ");
		}
	}

	@Disabled
	@Test
	@DisplayName("Student  # Update one student")
	@Order(4)
	public void testUpdateStudent() throws Exception {

		// 1
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.put("/v1/api/student/modify")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(
						"{\"stdId\":3,\"stdName\":\"Salim Khan\",\"stdGen\":\"Male\",\"stdCourse\":\"Mechanical\",\"stdAdd\":\"SA 994554\"}");
		// 2
		MvcResult result = mockMvc.perform(req).andReturn();
		// 3
		MockHttpServletResponse response = result.getResponse();
		// 4
		assertNotNull(response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());

		assertEquals("application/json", response.getContentType());
		if (!response.getContentAsString().contains("updated")) {
			fail("Student data not updated ");
		}
	}

	@Test

	@DisplayName("Student  # Delete one student")

	@Order(5)
	public void testRemoveStudent() throws Exception {

		// 1

		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.delete("/v1/api/student/remove/{id}", 2)
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		// 2

		MvcResult result = mockMvc.perform(req).andReturn();
		// 3
		MockHttpServletResponse response = result.getResponse();

		// 4 assertNotNull(response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());

		assertEquals("application/json", response.getContentType());

		if (!response.getContentAsString().contains("deleted")) {
			fail("Looks student data not exists ");
		}
	}

}
