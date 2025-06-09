package utils;

import demoQATraining.pageObjects.LoginPage;
import demoQATraining.pageObjects.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;

    public void initDriver() throws IOException {


        String browser = ConfigReader.get("browser");
        String mode = ConfigReader.get("mode");
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();

                WebDriverManager.chromedriver().setup();
                options.addArguments(mode);
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser name specified is not supported");
        }

        driver.manage().window().maximize();
    }

    @BeforeMethod
    protected void launchApp() throws IOException {
        initDriver();
    }

    @AfterMethod
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected LoginPage loginPage() {
        return new LoginPage(driver);
    }

    protected ProductPage productPage() {
        return new ProductPage(driver);
    }

}
