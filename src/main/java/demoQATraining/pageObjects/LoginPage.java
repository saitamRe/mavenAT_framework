package demoQATraining.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "user-name")
    private static WebElement emailBox;

    @FindBy(id = "password")
    private static WebElement passwordBox;

    @FindBy(id = "login-button")
    private static WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Login(String email, String password) {
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }


}
