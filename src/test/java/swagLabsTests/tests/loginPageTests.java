package swagLabsTests.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

public class loginPageTests extends BaseTest {

    @Parameters({"url"})
    @Test(groups = {"smokee", "postDeployChecks"})
    public void loginTest(String url)
    {

        System.out.println(url);
    }

    public void getData()
    {

    }

}
