package demoqa.pages;

import demoqa.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    private By login = By.xpath("(//span[contains(text(),'Dealer Sign In')])[1]");
    private By hrefLogin = By.cssSelector("a[href='https://ficedaau.dev.bluecomvn.com/customer/account/login/']");
    private By myAccount = By.cssSelector("div[class='panel header'] a[data-bind=\"text: new String('View Balance')\"]");
    private By lblSearch = By.id("search");
    private By iconSearch = By.xpath("//button[@title='Search']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public LoginPage goLoginPage (){
        validateHelper.clickElement(login);
        validateHelper.clickElement(hrefLogin);
        return new LoginPage(driver);
    }
    public MyAccountPage goMyAccountPage (){
        validateHelper.clickElement(myAccount);
        return new MyAccountPage(driver);
    }

    public void SearchProduct(String sku){
        validateHelper.enterText(lblSearch, sku);
        validateHelper.submitByEnter(lblSearch);
    }
}
