package demoQATraining.pageObjects;

import demoQATraining.abstractComponents.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends BasePage {

    WebDriver driver;

    private static final By ADD_TO_CART_BTN_BY = By.cssSelector("button.btn_inventory");
    private static final By PRODUCT_ITEM_NAME_BY = By.cssSelector("div.inventory_item_name");
    private static final By PRODUCT_ITEM_BY = By.cssSelector("div.inventory_item");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");


    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //getProducts
    public List<WebElement> getProducts() {
        waitForCondition(ExpectedConditions.visibilityOfElementLocated(PRODUCT_ITEM_NAME_BY), 3);
        return driver.findElements(PRODUCT_ITEM_BY);
    }

    public String getNameOfFirstProduct()
    {
        List<WebElement> prods = getProducts();
        return prods.get(0).findElement(PRODUCT_ITEM_NAME_BY).getText();
    }

    //countAllItems
    public int countProductItems() {
           return getProducts().size();
    }

    //getProductByName
    public WebElement getProductByName(String productName) {

        for (WebElement product : getProducts()) {
                WebElement nameElement = product.findElement(PRODUCT_ITEM_NAME_BY);
                if (nameElement.getText().equalsIgnoreCase(productName)) {
                    return product;
                }
        }
        throw new NoSuchElementException("Product is not found " + productName);
    }

    //addToCart
    public void addItemToCart(String productName) {
        WebElement e = getProductByName(productName)
                .findElement(ADD_TO_CART_BTN_BY);
        clickOnElementJs(e);
    }

    public void clickOnCartBtn()
    {
        WebElement e = driver.findElement(CART_BUTTON);
        clickOnElementJs(e);
    }

}
