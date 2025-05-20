package demoQATraining.pageObjects;

import demoQATraining.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends AbstractComponent {
    WebDriver driver;

    @FindBy(css = "div.inventory_item")
    private List<WebElement> productItems;

    private final By addToCartBtnBy = By.cssSelector("button.btn_inventory");

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //getProducts
    public List<WebElement> getProducts()
    {
        waitForElementToAppear(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.inventory_item")), 3);
        return productItems;
    }

    //countAllItems
    public int countProductItems()
    {
        return productItems.size();
    }

    //getProductByName
    public WebElement getProductByName(String productName)
    {

        return getProducts().stream().filter(product -> product.findElement(By.cssSelector("div.inventory_item_name")).getText()
                .equalsIgnoreCase(productName))
                .findAny()
                .orElse(null);
    }

    //addToCart
    public void addItemToCart(String productName)
    {
        getProductByName(productName)
                .findElement(addToCartBtnBy)
                .click();

    }

}
