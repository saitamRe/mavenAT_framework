package utils;

import demoQATraining.pageObjects.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTestWithLogin extends BaseTest {
    @BeforeMethod
    protected void login(Method method) {
        LoginPage lp = loginPage();
        driver.get(ConfigReader.get("env"));

        if (method.getName().contains("performance_glitch_user")) {
            lp.Login("performance_glitch_user", "secret_sauce");
        } else {
            lp.Login("standard_user", "secret_sauce");
        }
    }
}