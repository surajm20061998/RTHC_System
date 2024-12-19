// File: src/main/java/com/example/healthcare_system/exception/ResourceNotFoundException.java
package com.realTimeHealthcare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a requested resource is not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L; // For serialization

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     *
     * @param message Detailed message explaining the exception.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message and cause.
     *
     * @param message Detailed message explaining the exception.
     * @param cause   The cause of the exception.
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
