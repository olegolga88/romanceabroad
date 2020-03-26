import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class BaseActions {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public static String generateNewNumber(String name, int length) {
        return name + RandomStringUtils.random(length, "1729847557");
    }

    public void getDropDownListByIndex(By locator, int index) {
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }

    public void getDropDownListByText(By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    public void getDropDownListByValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }



    public void getElementIsDisplayed(By locator){
        WebElement element= driver.findElement(locator);
        boolean elementDisplayed= element.isDisplayed();
        if(element.isDisplayed()){
            System.out.println(elementDisplayed + ""+ "element is displayed");
        }else {
            System.out.println(elementDisplayed + ""+ "element is not displayed");
        }
    }

    public void getTextString(By locator, String text){
        driver.findElement(locator).getText();
        System.out.println(text);
    }

    public void getTextNumber (By locator, int number){
        driver.findElement(locator).getText();
        System.out.println( number);
    }

    public void getClickByMouse(WebElement element){
        Actions action= new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void getBackStep(){
        driver.navigate().back();
    }

    public void ajaxClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

    public void ajaxClick(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElement(by));
    }

    //Works very good with Chrome, Firefox, not IE
    public void ajaxClick(By by, int index) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElements(by).get(index));
    }

    //Works very good with IE
    public void performClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    public void performClick(By locator, int index) {
        WebElement element = driver.findElements(locator).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();


    }

    public void performClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    public void clickUnselectedCheckbox(By checkbox){
        WebElement currentCheckbox=driver.findElement(checkbox);
        if(!currentCheckbox.isSelected()){
            ajaxClick(currentCheckbox);
        }
    }

    public void scrollToBottomOfPage(){
        ((JavascriptExecutor)driver).executeScript("window scrollTo(0,document.body.scrollHeight);");

    }

public void ajaxScroll(WebElement element){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
    wait.until(ExpectedConditions.elementToBeClickable(element));
}

}