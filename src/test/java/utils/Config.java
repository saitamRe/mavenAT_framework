package utils;

public class Config {
    private static final String baseUrl = System.getProperty("url", "https://www.saucedemo.com/");
    public static String getBaseUrl()
    {

        return baseUrl;
    }
}
