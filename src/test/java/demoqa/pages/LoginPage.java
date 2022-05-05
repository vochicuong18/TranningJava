package demoqa.pages;

import demoqa.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    private By userNameTxt = By.id("email");
    private By passWordTxt = By.id("pass");
    private By submitBtn = By.id("send2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public MyAccountPage Login(String email, String passWord) {
        validateHelper.enterText(userNameTxt, email);
        validateHelper.enterText(passWordTxt, passWord);
        validateHelper.clickElement(submitBtn);
        return new MyAccountPage(driver);
    }
}
