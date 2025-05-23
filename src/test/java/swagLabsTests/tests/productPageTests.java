package swagLabsTests.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

public class productPageTests extends BaseTest {
    @Test(groups = {"regression"}, dependsOnMethods = {"c"})
    public void a() {
//        lp.Login("standard_user", "secret_sauce");
//        ProductPage prP = new ProductPage(driver);
//        prP.addItemToCart("Sauce Labs Backpack");
        System.out.println("productItemTest_A");
    }

    @Parameters({"url", "api_key"})
    @Test(groups = {"regression"})
    public void b(String url, String apikey) {

        System.out.println("url = " + url);
        System.out.println("apy_key = " + apikey);

    }

    @Test(groups = {"smokee"}, dataProvider = "getData")
    public void c(String un, String pass) {

        System.out.println("productItemTest_C");
        System.out.println(un + " " + pass);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "firstUserName";
        data[0][1] = "password";

        data[1][0] = "secondUserName";
        data[1][1] = "password";

        data[2][0] = "thirdUserName";
        data[2][1] = "password";

        return data;
    }
}
