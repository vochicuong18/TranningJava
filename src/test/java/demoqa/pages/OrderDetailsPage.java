package demoqa.pages;

import demoqa.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class OrderDetailsPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    private By idOrder = By.cssSelector("a[class='order-number'] strong");
    private By lblNameProduct = By.xpath("//strong[@class='product name product-item-name']");
    private By lblSKU = By.xpath("//td[@class='col sku']");
    private By lblPrice = By.cssSelector("td[class='col price'] span[class='price']");
    private By lblQty = By.xpath("//tbody//li[1]//span[2]");

    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void goOrderDetailsPage() {
        validateHelper.clickElement(idOrder);
    }

    public void verifyOrder(String nameProduct, String sku, String price, String qty) {
        String nameProductPage = validateHelper.getTextFromLabel(lblNameProduct);
        String skuPage = validateHelper.getTextFromLabel(lblSKU);
        String pricePage = validateHelper.getTextFromLabel(lblPrice);
        String qtyPage = validateHelper.getTextFromLabel(lblQty);
        Assert.assertEquals(nameProduct, nameProductPage);
        Assert.assertEquals(skuPage, sku);
        Assert.assertEquals(pricePage, price);
        Assert.assertEquals(qtyPage, qty);

    }
}
