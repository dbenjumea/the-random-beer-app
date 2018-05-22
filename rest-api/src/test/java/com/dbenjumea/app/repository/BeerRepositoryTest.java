package com.dbenjumea.app.repository;

import com.dbenjumea.app.entity.Beer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class BeerRepositoryTest {

	@Autowired
	private BeerRepository beerRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void shouldReturnBeerById() {
		// given
		Beer beer = new Beer();
		beer.setAbv(4.3);
		beer.setName("METALMAN PALE ALE (CANNED)");

		beer = entityManager.persist(beer);

		// when
		Optional<Beer> found = beerRepository.findById(beer.getId());

		// then
		assertTrue(found.isPresent());
	}
}
