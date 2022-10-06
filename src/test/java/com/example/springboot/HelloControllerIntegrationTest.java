package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {

    @Autowired
    // The embedded server starts on a random port
    // and the actual random port is configured automatically in the base URL for the TestRestTemplate
    private TestRestTemplate restTemplate;

    @Test
    void getHello() throws Exception {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/", String.class);
        assertThat(responseEntity.getBody())
                .isEqualTo("Greetings from Spring Boot!");
    }
}
