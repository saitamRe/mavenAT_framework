package swagLabsTests.tests;

import utils.LoginDataProvider;
import org.testng.annotations.Test;
import utils.BaseTest;

public class CheckoutTests extends BaseTest {
    @Test(groups = {""}, dataProvider = "getLoginData", dataProviderClass = LoginDataProvider.class)
    public void checkout(String login, String email) {

        System.out.println(login + " " + email);
    }
}
