package swagLabsTests.tests;

import demoQATraining.pageObjects.CartPage;
import demoQATraining.pageObjects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.BaseTestWithLogin;

public class CartTests extends BaseTestWithLogin {
    @Test
    public void itemInCartTest() throws InterruptedException {
        ProductPage prP = new ProductPage(driver);
        String nameOfFirst = prP.getNameOfFirstProduct();
        prP.addItemToCart(nameOfFirst);
        Thread.sleep(2000);
        prP.clickOnCartBtn();

        CartPage crtP = new CartPage(driver);

        Assert.assertEquals(crtP.getNamesOfProducts().get(0), nameOfFirst);
        Thread.sleep(2000);
        Assert.assertTrue(crtP.isCartTitleDisplayed());
        Assert.assertTrue(crtP.isDescLabelDisplayed());
        Assert.assertTrue(crtP.isItemNameDisplayed());
        Assert.assertTrue(crtP.isQuantityDisplayed());
    }
}
