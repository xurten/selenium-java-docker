package com.logging;

import com.database.IRepository;
import com.utils.DateUtils;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.UUID;

public class MyLogger implements IMyLogger{
    private IRepository databaseRepository;

    public MyLogger(IRepository repository)
    {
        databaseRepository = repository;
        databaseRepository.prepereDatabase();
    }

    @Override
    public void logSuccess(String message) {
        Reporter.log(message, ITestResult.SUCCESS);
        String success = "SUCCESS";
        String currentDate = DateUtils.GetActualDate();
        databaseRepository.executeUpdateWithDb(String.format("insert into logs(message, testName, currentDate) values ('%s', '%s', '%s');", message, success, currentDate));
    }

    @Override
    public void logFailure(String message) {
        Reporter.log(message, ITestResult.FAILURE);
        Reporter.log(message, ITestResult.SUCCESS);
        int id = UUID.randomUUID().variant();
        String success = "FAILURE";
        String currentDate = "2019-10-13 19:20:00";
        databaseRepository.executeUpdateWithDb(String.format("insert into logs(message, testName, currentDate) values ('%s', '%s', '%s');",  message, success, currentDate));
    }
}
