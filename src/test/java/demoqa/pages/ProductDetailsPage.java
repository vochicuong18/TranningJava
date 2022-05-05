package demoqa.pages;

import demoqa.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    private By btnAddCart = By.id("product-addtocart-button");
    private By iconCart = By.xpath("//a[@class='action showcart']//span[@class='counter qty']");
    private By btnCheckout = By.id("top-cart-btn-checkout");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void addProducToCart(){
        validateHelper.clickElement(btnAddCart);
    }

    public void proceedToCheckout(){
        validateHelper.clickElement(iconCart);
        validateHelper.clickElement(btnCheckout);
    }
}
