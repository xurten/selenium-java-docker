package com.logging;

import org.testng.ITestResult;
import org.testng.Reporter;

public class MyLogger implements IMyLogger{

    @Override
    public void logSuccess(String message) {
        Reporter.log(message, ITestResult.SUCCESS);
    }

    @Override
    public void logFailure(String message) {
        Reporter.log(message, ITestResult.FAILURE);
    }
}
