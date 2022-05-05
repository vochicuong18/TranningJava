package demoqa.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    public ValidateHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }
    public void maximizeBrowserWindow() {
        driver.manage().window().maximize();
    }

    public void enterText(By element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }

    public void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor exe = (JavascriptExecutor)driver;
        WebElement ele = driver.findElement(element);
        exe.executeScript("arguments[0].click();", ele );
    }

    public String getTextFromLabel(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        String text = driver.findElement(element).getText();
        System.out.println(text);
        return text;
    }

    public void submitByEnter(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).sendKeys(Keys.ENTER);
    }

}
