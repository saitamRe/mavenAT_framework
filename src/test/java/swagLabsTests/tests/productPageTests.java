package swagLabsTests.tests;

import demoQATraining.pageObjects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.BaseTestWithLogin;

public class productPageTests extends BaseTestWithLogin {

    @Test
    public void checkItemsNumberAsStandardTest()
    {
        ProductPage prP = productPage();
        Assert.assertEquals(prP.countProductItems(), 6);
    }

}
