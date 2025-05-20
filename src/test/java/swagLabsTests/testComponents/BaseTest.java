package swagLabsTests.testComponents;

import demoQATraining.pageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LoginPage lp;

    public WebDriver initDriver() throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\globalData.properties");
        props.load(fis);

        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : props.getProperty("browser");

        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public void launchApp() throws IOException {
        initDriver();
        lp = new LoginPage(driver);
        lp.goTo(true);
    }

    @AfterMethod
    public void tearDown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }

}
