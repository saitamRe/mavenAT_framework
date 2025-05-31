package swagLabsTests.tests;

import demoQATraining.pageObjects.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.JsonReader;
import utils.dataProviders.LoginDataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class loginPageTests extends BaseTest {

    @Test(groups = {"smokee", "postDeployChecks"})
    public void loginTest() throws IOException, InterruptedException {
        List<HashMap<String, String>> data = JsonReader.getJsonDataToMap("users.json");
        LoginPage lp = new LoginPage(driver);
        lp.goTo(false);
        HashMap<String, String> hm = data.get(1);
        lp.Login(hm.get("email"), hm.get("password"));
        Thread.sleep(2000);
    }

    @Parameters
    @Test(dataProvider = "getStandardUserCreds" , dataProviderClass = LoginDataProvider.class)
    public void getData(HashMap<String, String> input)
    {
        System.out.println("Email: " + input.get("email") + "Password: " + input.get("password"));
    }

}
