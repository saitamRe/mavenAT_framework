package utils;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTestWithLogin extends BaseTest {
    @BeforeMethod
    public void login(Method method) {
        if (method.getName().contains("Standard")) {
            lp.Login("standard_user", "secret_sauce");
        } else {
            lp.Login("performance_glitch_user", "secret_sauce");
        }
    }
}
