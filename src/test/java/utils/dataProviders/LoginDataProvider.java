package utils.dataProviders;

import org.testng.annotations.DataProvider;
import utils.JsonReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class LoginDataProvider {

    @DataProvider(name = "getStandardUserCreds")
    public static Object[][] getStandardUserCreds() throws IOException {
        return getCredsByIndex(0);
    }

    @DataProvider(name = "getVisualUserCreds")
    public static Object[][] getVisualUserCreds() throws IOException {
        return  getCredsByIndex(1);
    }

    @DataProvider(name = "getCredsByIndex")
    public static Object[][] getCredsByIndex(int index) throws IOException {
        List<HashMap<String, String>> data = JsonReader.getJsonDataToMap("users.json");
        return new Object[][]{
                {data.get(index)}
        };
    }
}
