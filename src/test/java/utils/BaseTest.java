package utils;

import demoQATraining.pageObjects.LoginPage;
import demoQATraining.pageObjects.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;

    public WebDriver initDriver() throws IOException {
        Properties props = new Properties();
        File file = Paths.get(System.getProperty("user.dir"), "src", "test", "java", "resources", "globalData.properties").toFile();
        try (FileInputStream fis = new FileInputStream(file)) {
            props.load(fis);
        }

        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : props.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser name specified is not supported");
        }

        driver.manage().window().maximize();
        return driver;
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
