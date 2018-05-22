package com.dbenjumea.app.resource;

import com.dbenjumea.app.entity.Beer;
import com.dbenjumea.app.exception.BeerNotFoundException;
import com.dbenjumea.app.service.BeerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Optional;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebFluxTest(BeerResource.class)
public class BeerResourceTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private BeerService beerService;

    @Test
    public void shouldReturnBeerById() throws BeerNotFoundException {
        // given
        given(this.beerService.findById(1L))
                .willReturn(Optional.of(new Beer()));
        this.webClient.get().uri("/beers/1").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Honda Civic");
    }
}
