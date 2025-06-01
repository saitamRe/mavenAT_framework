package demoQATraining.pageObjects;

import demoQATraining.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends AbstractComponent {
    WebDriver driver;

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
        return driver.findElements(By.cssSelector("div.inventory_item"));
    }

    //countAllItems
    public int countProductItems()
    {
        return getProducts().size();
    }

    //getProductByName
    public WebElement getProductByName(String productName)
    {

        for (WebElement product : getProducts())
        {
            try {
                WebElement nameElement = product.findElement(By.cssSelector("div.inventory_item_name"));
                if(nameElement.getText().equalsIgnoreCase(productName))
                {
                    return product;
                }
            }
            catch (NoSuchElementException e)
            {}
        }
        return null;
    }

    //addToCart
    public void addItemToCart(String productName)
    {
        getProductByName(productName)
                .findElement(addToCartBtnBy)
                .click();

    }

}
