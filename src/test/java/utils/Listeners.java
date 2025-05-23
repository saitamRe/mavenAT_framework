package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }
}
