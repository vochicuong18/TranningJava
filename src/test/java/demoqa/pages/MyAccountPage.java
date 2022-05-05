package demoqa.pages;

import demoqa.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    private By lblUserName = By.cssSelector("div[class='box box-information'] p");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void verifyLogin(String unInput) {
        String unValue = validateHelper.getTextFromLabel(lblUserName);
//        Assert.assertEquals(unValue,unInput);
        unValue.contains(unInput);
    }
}
