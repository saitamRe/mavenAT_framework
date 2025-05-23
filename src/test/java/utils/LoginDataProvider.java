package utils;

import org.testng.annotations.DataProvider;


public class LoginDataProvider {

    @DataProvider(name = "getLoginData")
    public static Object[][] getLoginData() {
      return new Object[][]{{"standard_user", "secret_sauce"}, {"error_user", "secret_sauce"}};

    }
}
