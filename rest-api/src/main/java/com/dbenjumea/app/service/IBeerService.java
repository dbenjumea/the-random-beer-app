package com.dbenjumea.app.service;

import com.dbenjumea.app.entity.Beer;
import com.dbenjumea.app.exception.BeerNotCreatedException;
import com.dbenjumea.app.exception.BeerNotFoundException;

import java.util.Optional;

public interface IBeerService {
    Optional<Beer> findById(long id) throws BeerNotFoundException;

    void deleteById(long id);

    Beer save(Beer beer) throws BeerNotCreatedException;

    int countOfBeers();
}
