package org.example.Exceptionhandling;

public class DatabaseReadException extends RuntimeException {
    public DatabaseReadException(String message) {

        super(message);
    }
}
