package demoQATraining.abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToAppear(ExpectedCondition condition, int duration)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wait.until(condition);
        }
        catch (TimeoutException ex)
        {
            throw new AssertionError("Condition of wait is failed" + " " + condition + " " + ex);
        }
    }

    public void waitForElementToAppear(ExpectedCondition condition)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(condition);
        }
        catch (TimeoutException ex)
        {
            throw new AssertionError("Condition of wait is failed" + " " + condition + " " + ex);
        }

    }
}
