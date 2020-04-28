package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MediaPageTests extends BaseUI {
    String currentUrlMedia;
    String actualTitle;


    @Test
    public void testMediaPage() {
        mediaPage.clickMediaPageLink();
        currentUrlMedia = driver.getCurrentUrl();
        System.out.println(currentUrlMedia);
        //Assert.assertEquals(currentUrlMedia, com.romanceabroad.ui.Data.expectedUrlMedia);
        softAssert.assertEquals(currentUrlMedia, Data.expectedUrlMedia, "Url is wrong");
        softAssert.assertAll();


    }

    @Test
    public void testListOfButtonsMedia() {
        mediaPage.clickMediaPageLink();
        currentUrlMedia = driver.getCurrentUrl();
        System.out.println(currentUrlMedia);

        List<WebElement> links = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            mediaPage.ajaxClick(links.get(i));
            String info = links.get(i).getText();
            System.out.println(info);

            driver.get(currentUrlMedia);
            links = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        }

    }


    @Test
    public void testUserTabs() {
        mediaPage.clickMediaPageLink();
        List<WebElement> userTabs = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        actualTitle = mediaPage.getAnyTitle();
        Assert.assertEquals(actualTitle, Data.expectedTitleAllPhotos);
        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            actualTitle = mediaPage.getAnyTitle();

            if (i == 0) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGallery);
            } else if (i == 1) {
                Assert.assertEquals(actualTitle, Data.expectedTitlePhotoGallery);
            } else if (i == 2) {
                Assert.assertEquals(actualTitle, Data.expectedTitleVideo);
            } else if (i== 3) {
                Assert.assertEquals(actualTitle, Data.expectedTitleAlbums);
            }
            userTabs = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        }}



}
