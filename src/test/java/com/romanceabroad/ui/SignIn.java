package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignIn extends BaseUI{
    @Test(dataProvider = "NewRequirementsForPassword", dataProviderClass = DataProviders.class)
    public void password(String password, boolean requirement){
        mainPage.clickSignInLink();
        mainPage.inputDataSignIn(Data.email1, password);
        /*driver.findElement(Locators.TEXT_FIELD_EMAIL_SIGN_IN).sendKeys(Data.email1);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD_SIGN_IN).sendKeys(Data.password);*/
        if (!requirement) {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement errorMessage = driver.findElement(Locators.ERROR_MESSAGE_EMAIL_OR_PASSWORD_INCORRECT);
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            Assert.assertTrue(errorMessage.isDisplayed());
            System.out.println("Email or password is incorrect");
        } else {
            mainPage.inputDataSignIn(Data.email1, password);
    }
}}
