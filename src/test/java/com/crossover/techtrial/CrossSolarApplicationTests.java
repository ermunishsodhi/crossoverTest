package com.crossover.techtrial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrossSolarApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CrossSolarApplicationTests {

  @LocalServerPort
  private int port;

  TestRestTemplate restTemplate = new TestRestTemplate();

  HttpHeaders headers = new HttpHeaders();

  @Test
  public void testRetrieveStudentCourse() {

    HttpEntity<String> entity = new HttpEntity<String>(null, headers);

    ResponseEntity<String> response = restTemplate.exchange(
            createURLWithPort("/api/panels"),
            HttpMethod.GET, entity, String.class);

    String expected = "{id:Course1,name:Spring,description:10 Steps}";

    System.out.println(response);
//    JSONAssert.assertEquals(expected, response.getBody(), false);
  }

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }


  @Test
  public void contextLoads() {
    
  }

}
