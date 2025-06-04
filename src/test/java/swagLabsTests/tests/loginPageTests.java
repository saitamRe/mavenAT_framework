package swagLabsTests.tests;

import demoQATraining.pageObjects.LoginPage;
import demoQATraining.pageObjects.ProductPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.BaseTestWithLogin;
import utils.JsonReader;
import utils.dataProviders.LoginDataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class loginPageTests extends BaseTestWithLogin {

    @Test(groups = {"smokee", "postDeployChecks"}, dataProvider = "getStandardUserCreds", dataProviderClass = LoginDataProvider.class)
    public void loginTest(HashMap<String, String> data) throws IOException, InterruptedException {

        ProductPage prPage = new ProductPage(driver);
        WebElement firstProduct = prPage.getProductByName("Sauce Labs Backpack");
        Assert.assertNotNull(firstProduct, "The 'Sauce Labs Backpack' item is not found");
        Assert.assertTrue(firstProduct.isDisplayed());
    }
}