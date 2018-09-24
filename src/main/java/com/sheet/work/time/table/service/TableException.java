package com.sheet.work.time.table.service;

public class TableException extends Exception {
    String mesage = "All bad";
    public TableException() {
    }

    public TableException(String message) {
        message= this.mesage;
    }
}
