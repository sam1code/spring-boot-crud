package com.samread.samread.enitites;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CourseDel {
    private String message;
    private ResponseEntity<HttpStatus> status;

    public CourseDel(String message, ResponseEntity<HttpStatus> status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public ResponseEntity<HttpStatus> getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(ResponseEntity<HttpStatus> status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseDel{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }

    public CourseDel() {
        super();
    }
}
