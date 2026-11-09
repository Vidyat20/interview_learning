package Listeners;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Demoqa.BaseClass;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        BaseClass testClass = (BaseClass) result.getInstance();

        if (testClass.getDriver() != null) {

            String dateTime = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")
            );

            String testName = result.getName() + "_" + dateTime;

            testClass.captureScreenshot(testName);
        }
    }
}