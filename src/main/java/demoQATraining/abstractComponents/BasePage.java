package demoQATraining.abstractComponents;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public <T> T waitForCondition(ExpectedCondition<T> condition, int duration)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            return wait.until(condition);
        }
        catch (TimeoutException ex)
        {
            throw new AssertionError("Condition of wait is failed" + " " + condition + " " + ex);
        }
    }

    public <T> T waitForCondition(ExpectedCondition<T> condition)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            return wait.until(condition);
        }
        catch (TimeoutException ex)
        {
            throw new AssertionError("Condition of wait is failed" + " " + condition + " " + ex);
        }

    }

    public boolean isElementVisible(By locator)
    {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementVisible(By locator, int timeOutDuration)
    {
        try {
            waitForCondition(ExpectedConditions.visibilityOfElementLocated(locator), timeOutDuration);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(By locator)
    {
        waitForCondition(ExpectedConditions.elementToBeClickable(locator), 1).click();
    }

    //we cant click on some elements of the sauceDemo site w/o JS executor, for example on the cart link in header
    public void clickOnElementJs(WebElement element)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    public void clickOnElement(By locator, int timeOutDuration)
    {
        waitForCondition(ExpectedConditions.elementToBeClickable(locator), timeOutDuration).click();
    }
}
