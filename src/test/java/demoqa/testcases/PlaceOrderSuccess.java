package demoqa.testcases;

import data.Product;
import data.User;
import demoqa.pages.*;
import helper.JsonHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.Json;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PlaceOrderSuccess {
    private WebDriver driver;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public HomePage homePage;
    public SearchPage searchPage;
    public ProductDetailsPage productDetailsPage;
    public ShippingPage shippingPage;
    public PaymentPage paymentPage;
    public OrderDetailsPage orderDetailsPage;
    @BeforeTest
    public void launchBroswer() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ficedaau.dev.bluecomvn.com/");

    }

    @Test(priority = 1, dataProviderClass = JsonHelper.class, dataProvider = "getAccount")
    public void loginSuccess(User user) {
        homePage = new HomePage(driver);
        loginPage = homePage.goLoginPage();
        myAccountPage = loginPage.Login(user.getUserName(), user.getPassWord());
    }

    @Test(priority = 2, dataProviderClass = JsonHelper.class, dataProvider = "getProduct")
    public void searchProduct(Product product) {
        homePage.SearchProduct(product.getSku());
    }

    @Test(priority = 3)
    public void addProductToCart() {
        searchPage = new SearchPage(driver);
        searchPage.gotoPDP();
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addProducToCart();
    }

    @Test(priority = 4, dataProviderClass = JsonHelper.class, dataProvider = "getAccount")
    public void placeOrderSuccess(User user) {
        productDetailsPage.proceedToCheckout();

        shippingPage = new ShippingPage(driver);
        shippingPage.enterCustomerPO(user.getNameCustomerPO());
        shippingPage.goPaymentPage();

        paymentPage = new PaymentPage(driver);
        paymentPage.payOnAccount();
        paymentPage.submitOrder();
    }
    @Test(priority = 5, dataProviderClass = JsonHelper.class, dataProvider = "getProduct")
    public void verifyOrder(Product product){
        orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.goOrderDetailsPage();
        orderDetailsPage.verifyOrder(product.getNameProduct(),product.getSku(),product.getPrice(),product.getQty());
    }


    @AfterTest()
    public void CloseBroswer() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
