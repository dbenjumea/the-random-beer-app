package com.dbenjumea.app.resource;

import com.dbenjumea.app.entity.Beer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    private static final String HOST = "http://localhost:";

    private static final String LIST_OF_BEER_BY_ID = "beers";

    private static final String FIRST_BEER_IN_LIST = "\"id\":1,\"name\":\"DEVIL’S BACKBONE\"";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject(HOST + port + "/",
                String.class)).contains("Hello World");
    }

    @Test
    public void shouldReturnBeerById() throws Exception {
        assertThat(this.restTemplate.getForObject(HOST + port + "/" + LIST_OF_BEER_BY_ID,
                String.class)).contains(FIRST_BEER_IN_LIST);
    }
}
