package com.dbenjumea.app.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeerResourceTest {

    @Autowired
    private BeerResource beerResource;

    @Test
    public void shouldReturnBeerById() {
        assertThat(beerResource).isNotNull();
    }
}
