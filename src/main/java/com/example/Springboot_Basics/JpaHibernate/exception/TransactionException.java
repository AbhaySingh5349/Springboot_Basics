package com.example.Springboot_Basics.JpaHibernate.exception;

public class TransactionException extends RuntimeException{
    public TransactionException(String message) {
        super(message);
    }
}
