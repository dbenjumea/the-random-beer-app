package com.dbenjumea.app.exception;

public class BeerNotFoundException extends Exception{

    public BeerNotFoundException(Long id) {
        super("Not found beer with ID: " + id);
    }

    public BeerNotFoundException(String name) {
        super("Not found beer with name: " + name);
    }

    public BeerNotFoundException(Long id, String name) {
        super("Not found beer with ID: " + id + " and with name: " + name);
    }
}
