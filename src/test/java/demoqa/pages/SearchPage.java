package demoqa.pages;

import demoqa.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    private By productName = By.xpath("//div[@class='column main']//li[1]//div[1]//span");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void gotoPDP() {
        validateHelper.clickElement(productName);
    }
}
