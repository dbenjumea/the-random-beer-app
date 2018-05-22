package com.dbenjumea.app.service;

import com.dbenjumea.app.entity.Beer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeerServiceTest {

    @Autowired
    private BeerService beerService;


    @Test
    public void shouldReturnCountOfBeers() {
        // given
        Beer beer = new Beer();
        beer.setAbv(4.3);
        beer.setName("METALMAN PALE ALE (CANNED)");

        // when
        int countOfBeers = beerService.countOfBeers();

        // then
        assertEquals(countOfBeers, 5);
    }
}
