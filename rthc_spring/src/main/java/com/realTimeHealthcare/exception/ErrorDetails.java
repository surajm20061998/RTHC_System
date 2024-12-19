// File: src/main/java/com/example/healthcare_system/exception/ErrorDetails.java
package com.realTimeHealthcare.exception;

import java.time.LocalDateTime;

/**
 * Structure for error details in API responses.
 */
public class ErrorDetails {
    
    private LocalDateTime timestamp;
    private String message;
    private String details;
    
    // Constructors
    public ErrorDetails() {}
    
    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
    
    // Getters and Setters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getDetails() {
        return details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
}
