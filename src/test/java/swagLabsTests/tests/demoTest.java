package swagLabsTests.tests;

import demoQATraining.pageObjects.LoginPage;
import demoQATraining.pageObjects.ProductPage;
import org.testng.annotations.Test;
import swagLabsTests.testComponents.BaseTest;

public class demoTest extends BaseTest {

    @Test
    public void loginTest()
    {
        lp.Login("standard_user", "secret_sauce");
        ProductPage prP = new ProductPage(driver);
        prP.addItemToCart("Sauce Labs Backpack");
    }
}
