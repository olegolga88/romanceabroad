package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickJoinButton() {
        driver.findElement(Locators.BUTTON_REGISTRATION).click();

    }

    public void completeFirstPartOfRegistration(String email, String password) {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);


    }
    public void clickNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));
        driver.findElement(Locators.BUTTON_NEXT).click();
    }

    public void completeSecondPartOfRegistration(String nickname, String day, String month,
                                                 String year, String phone, String location, String city) {
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(nickname);

        driver.findElement(Locators.BUTTON_DAY_BIRTH_DATE_FIELD).click();
        clickValueOfList(Locators.DROP_DOWN_LIST_SELECT_DAY, day);

        driver.findElement(Locators.BUTTON_MONTH_BIRTH_DATE_FIELD).click();
        clickValueOfList(Locators.DROP_DOWN_LIST_SELECT_MONTH, month);

        driver.findElement(Locators.BUTTON_YEAR_BIRTH_DATE_FIELD).click();
        clickValueOfList(Locators.DROP_DOWN_LIST_SELECT_YEAR, year);

        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phone);
        driver.findElement(Locators.AUTO_FILLING_FORM_LOCATION).clear();
        driver.findElement(Locators.AUTO_FILLING_FORM_LOCATION).sendKeys(city);
        clickValueOfList(Locators.LIST_VALUE_LOCATION, location);

    }
}




