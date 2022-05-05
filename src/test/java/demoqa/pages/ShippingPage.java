package demoqa.pages;

import demoqa.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    private By lblCustomerPO = By.xpath("//div[@name= 'shippingAddress.custom_attributes.amorderattr_customer_po']//div[@class ='control']//input");
    private By nextButton = By.xpath("//button[@class='button action continue primary']");

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void enterCustomerPO (String name){
        validateHelper.enterText(lblCustomerPO,name);
    }

    public void goPaymentPage (){
        validateHelper.clickElement(nextButton);
    }
}
