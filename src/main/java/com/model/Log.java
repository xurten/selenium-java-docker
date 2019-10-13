package com.model;

public class Log {
    private int id;
    private String message;
    private String success;
    private String currentDate;

    public Log(String message, String success, String currentDate)
    {
        id = 1;
        this.message = message;
        this.success = success;
        this.currentDate = currentDate;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getSuccess() {
        return success;
    }

    public String getCurrentDate() {
        return currentDate;
    }
}
