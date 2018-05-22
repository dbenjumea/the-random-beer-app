package com.dbenjumea.app.resource;

import com.dbenjumea.app.entity.Beer;
import com.dbenjumea.app.exception.BeerNotCreatedException;
import com.dbenjumea.app.exception.BeerNotFoundException;
import com.dbenjumea.app.repository.BeerRepository;
import com.dbenjumea.app.service.BeerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin
public class BeerResource {

    private final Logger logger = LoggerFactory.getLogger(BeerResource.class);

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private BeerService beerService;

    @GetMapping
    public String getHelloWorld() {
        return "Hello World";
    }

    @GetMapping(value = "/beers")
    public List<Beer> retrieveAllBeers() {
        List<Beer> list = beerRepository.findAll();
        return list;
    }

    @GetMapping("/beers/{id}")
    public Beer retrieveBeer(@PathVariable long id) throws BeerNotFoundException {
        Optional<Beer> beer = beerService.findById(id);
        return beer.get();
    }

    @GetMapping("/beers/count")
    public int countOfBeers() {
        return beerService.countOfBeers();
    }

    @DeleteMapping("/beers/{id}")
    public void deleteBeer(@PathVariable long id) {
        beerService.deleteById(id);
    }

    @PostMapping("/beers")
    public ResponseEntity<Object> createBeer(@RequestBody Beer beer) throws BeerNotCreatedException {
        Beer savedBeer = beerService.save(beer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedBeer.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/beers/{id}")
    public ResponseEntity<Object> updateBeer(@RequestBody Beer beer, @PathVariable long id) throws BeerNotFoundException, BeerNotCreatedException {

        Optional<Beer> beerOptional = beerService.findById(id);

        if (!beerOptional.isPresent())
            return ResponseEntity.notFound().build();

        beerService.save(beer);

        return ResponseEntity.ok("Beer created");
    }
}
