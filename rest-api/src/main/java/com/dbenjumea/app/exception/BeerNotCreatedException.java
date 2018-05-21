package com.dbenjumea.app.exception;

public class BeerNotCreatedException extends Exception{

    public BeerNotCreatedException() {
        super("Beer not created, check if the request is reaching with the values required and not null");
    }
}
