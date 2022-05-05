package demoqa.pages;

import demoqa.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    private By btnPay = By.xpath("//button[@id='use-customer-balance']");
    private By btnSubmit = By.xpath("//button[@title='Place Order']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
      validateHelper = new ValidateHelper(driver);
    }

    public void payOnAccount(){
        validateHelper.clickElement(btnPay);
    }

    public void submitOrder(){
        validateHelper.clickElement(btnSubmit);
    }
}
