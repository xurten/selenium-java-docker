package com.logging;

import com.database.IRepository;
import com.model.Log;
import com.utils.DateUtils;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyLogger implements IMyLogger{
    private IRepository databaseRepository;

    public MyLogger(IRepository repository)
    {
        databaseRepository = repository;
        databaseRepository.prepareDatabase();
    }

    @Override
    public void logSuccess(String message) {
        Reporter.log(message, ITestResult.SUCCESS);
        String success = "SUCCESS";
        String currentDate = DateUtils.GetActualDate();
        databaseRepository.add(new Log(message, success, currentDate));
    }

    @Override
    public void logInfo(String message) {
        Reporter.log("Info message " + message);
    }
}
