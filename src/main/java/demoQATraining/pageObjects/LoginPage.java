package demoQATraining.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement emailBox;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Login(String email, String password) {
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }

    public void goTo(boolean inANewTab) {
        if (inANewTab) {
            driver.get("https://www.saucedemo.com/");
        } else {
            driver.navigate().to("https://www.saucedemo.com/");
        }

    }

}
