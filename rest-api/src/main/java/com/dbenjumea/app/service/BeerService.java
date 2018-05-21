package com.dbenjumea.app.service;

import com.dbenjumea.app.entity.Beer;
import com.dbenjumea.app.exception.BeerNotCreatedException;
import com.dbenjumea.app.exception.BeerNotFoundException;
import com.dbenjumea.app.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public Optional<Beer> findById(long id) throws BeerNotFoundException {
        Optional<Beer> beer = beerRepository.findById(id);
        if(!beer.isPresent()) {
            throw new BeerNotFoundException(id);
        }
        return beer;
    }

    public void deleteById(long id) {
        beerRepository.deleteById(id);
    }

    public Beer save(Beer beer) throws BeerNotCreatedException {
        Optional<Beer> optionalBeer = Optional.of(beer);
        if(optionalBeer.isPresent())
            return beerRepository.save(beer);
        else
            throw new BeerNotCreatedException();
    }

    public int countOfBeers() {
        List<Beer> beerList = beerRepository.findAll();
        return beerList.size();
    }
}
