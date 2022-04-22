package com.unicap.bd2.DatabaseProject.Service.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id){
        super("Resource not found. id: "+id);
    }
}
