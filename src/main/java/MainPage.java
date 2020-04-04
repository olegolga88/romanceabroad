import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions{
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickJoinButton(){
        driver.findElement(Locators.BUTTON_REGISTRATION).click();

    }
    public void completeFirstPartOfRegistration (){

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(Data.email);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(Data.password);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));
        driver.findElement(Locators.BUTTON_NEXT).click();
    }
    public void completeSecondPartOfRegistration(){
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(generateNewNumber(Data.nickname,5));
        driver.findElement(Locators.BUTTON_DAY_BIRTH_DATE_FIELD).click();
        driver.findElement(Locators.DROP_DOWN_LIST_SELECT_DAY).click();
        driver.findElement(Locators.BUTTON_MONTH_BIRTH_DATE_FIELD).click();
        driver.findElement(Locators.DROP_DOWN_LIST_SELECT_MONTH).click();
        driver.findElement(Locators.BUTTON_YEAR_BIRTH_DATE_FIELD).click();
        driver.findElement(Locators.DROP_DOWN_LIST_SELECT_YEAR).click();
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(Data.Phone);
       // driver.findElement(Locators.TEXT_FIELD_LOCATION).sendKeys(Data.Location);


    }



    }

