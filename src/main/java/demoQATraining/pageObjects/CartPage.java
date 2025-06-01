package demoQATraining.pageObjects;

import demoQATraining.abstractComponents.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    private static final By CART_TITLE_BY = By.cssSelector(".title");
    private static final By CART_QUANTITY_LABEL_BY = By.cssSelector(".cart_quantity_label");
    private static final By CART_DESC_LABEL_BY = By.cssSelector(".cart_desc_label");
    private static final By CART_ITEM_NAME_BY = By.cssSelector(".inventory_item_name");
    private static final By CONTINUE_SHOPPING_BY = By.cssSelector("#continue-shopping");
    private static final By CHECKOUT_BUTTON_BY = By.cssSelector("#checkout");
    private static final By PRODUCT_CART_BY = By.cssSelector("cart_item");


    WebDriver driver;


    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isCartTitleDisplayed() {
        return isElementVisible(CART_TITLE_BY);
    }

    public boolean isDescLabelDisplayed() {
        return isElementVisible(CART_DESC_LABEL_BY, 3);
    }

    public boolean isQuantityDisplayed() {
        return isElementVisible(CART_QUANTITY_LABEL_BY, 3);
    }

    public boolean isItemNameDisplayed() {
        return isElementVisible(CART_ITEM_NAME_BY);
    }

    public List<String> getNamesOfProducts() {
        List<WebElement> prodList = driver.findElements(CART_ITEM_NAME_BY);
        return prodList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickOnContinueShopButton() {
        waitForCondition(ExpectedConditions.elementToBeClickable(CONTINUE_SHOPPING_BY), 1);
        driver.findElement(CONTINUE_SHOPPING_BY).click();
    }

    public void clickOnCheckoutButton() {
        clickOnElement(CHECKOUT_BUTTON_BY);
    }

}
