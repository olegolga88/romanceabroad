package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {

    @FindBy(xpath = "//button[@id='show-registration-block']")
    WebElement registrationButton;

    @FindBy(xpath = "//input[@id='email']")
    WebElement textFieldEmail;

    @FindBy(xpath = "//input[@id='password']")
    WebElement textFieldPassword;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickJoinButton() {

        Reports.log("click Join Button");
        registrationButton.click();

    }

    public void completeFirstPartOfRegistration(String email, String password) {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Reports.log("Wait Text Field Email");
        wait.until(ExpectedConditions.elementToBeClickable(textFieldEmail));

        Reports.log("Type Email in Text Field:" + email);
        textFieldEmail.sendKeys(email);

        Reports.log("Wait Text Field Password");
        wait.until(ExpectedConditions.visibilityOf(textFieldPassword));

        Reports.log("Type password in Text Field:" + password);
        textFieldPassword.sendKeys(password);


    }

    public void clickNextButton() {
        Reports.log("Wait Button Next");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));

        Reports.log("Click Button Next");
        driver.findElement(Locators.BUTTON_NEXT).click();
    }


    public void completeSecondPartOfRegistration(String nickname, String day, String month,
                                                 String year, String phone, String city, String location) {
        Reports.log("Type nickname in Text Field:" + nickname);
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(nickname);

        Reports.log("Click Birth date list");
        driver.findElement(Locators.BUTTON_DAY_BIRTH_DATE_FIELD).click();

        Reports.log("Select specific Day in Drop down list:" + day);
        clickValueOfList(Locators.DROP_DOWN_LIST_SELECT_DAY, day);

        Reports.log("Click Birth Month list:");
        driver.findElement(Locators.BUTTON_MONTH_BIRTH_DATE_FIELD).click();

        Reports.log("Select specific Month in Drop down list:" + month);
        clickValueOfList(Locators.DROP_DOWN_LIST_SELECT_MONTH, month);

        Reports.log("Click Birth Year list:");
        driver.findElement(Locators.BUTTON_YEAR_BIRTH_DATE_FIELD).click();

        Reports.log("Select specific Year in Drop down list:" + year);
        clickValueOfList(Locators.DROP_DOWN_LIST_SELECT_YEAR, year);

        Reports.log("Type phone number in Text Field:" + phone);
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phone);

        Reports.log("Clean auto filling form location");
        driver.findElement(Locators.AUTO_FILLING_FORM_LOCATION).clear();

        Reports.log("Type city:" + city);
        driver.findElement(Locators.AUTO_FILLING_FORM_LOCATION).sendKeys(city);

        Reports.log("Wait list of locations");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.LIST_VALUE_LOCATION));

        Reports.log("Click location:" + location);
        clickValueOfList(Locators.LIST_VALUE_LOCATION, location);

    }



    public void inputDataSignIn(String email, String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TEXT_FIELD_EMAIL_SIGN_IN));
        driver.findElement(Locators.TEXT_FIELD_EMAIL_SIGN_IN).sendKeys(email);
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TEXT_FIELD_PASSWORD_SIGN_IN));
        driver.findElement(Locators.TEXT_FIELD_PASSWORD_SIGN_IN).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_SIGN_IN));
        driver.findElement(Locators.BUTTON_SIGN_IN).click();

    }
    public void clickMobileMenu(String valueOfBox) {
        if (valueOfBox.contains("mobile")) {
            driver.findElement(Locators.MOBILE_MENU).click();
        }
    }
    public void clickMobileMenu() {
        try {
            driver.findElement(Locators.MOBILE_MENU).click();
        } catch (Exception e) {
        }
    }
    public void clickMobileMenu2() {
        if (driver.findElement(Locators.MOBILE_MENU).isDisplayed()){
            driver.findElement(Locators.MOBILE_MENU).click();
        }
    }

    public void clickMobileMenu3() {
        if (driver.findElements(Locators.MOBILE_MENU).size()>0){
            driver.findElement(Locators.MOBILE_MENU).click();
        }
    }

    public void clickSignInLink(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_SIGN_IN_MAIN_PAGE));
        driver.findElement(Locators.LINK_SIGN_IN_MAIN_PAGE).click();
    }

}



