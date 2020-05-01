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
wait.until(ExpectedConditions.presenceOfElementLocated(Locators.LIST_OF_BUTTONS_MEDIA));
        List<WebElement> links = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        System.out.println(links.size());

        for (int i = 1; i < links.size(); i++) {

            mediaPage.ajaxClick(Locators.LIST_OF_BUTTONS_MEDIA);
mediaPage.javaWaitSec(10);
            String info = links.get(i).getText();
            System.out.println(info);

            driver.get(currentUrlMedia);
            links = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        }

    }


    @Test
    public void testUserTabs() {
        mediaPage.clickMediaPageLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TITLE_OF_PAGE));
        List<WebElement> userTabs = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);

        actualTitle = mediaPage.getAnyTitle();
        Assert.assertEquals(actualTitle, Data.expectedTitleAllPhotos);
        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TITLE_OF_PAGE));
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
        }
    }
        @Test
        public void testUserTabs1() {
            mediaPage.clickMediaPageLink();
            wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TITLE_OF_PAGE));
            List<WebElement> userTabs = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);

            actualTitle = mediaPage.getAnyTitle();
            Assert.assertEquals(actualTitle, Data.expectedTitleAllPhotos);
            for (int i = 0; i < userTabs.size(); i++) {
                userTabs.get(i).click();
                wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TITLE_OF_PAGE));
                actualTitle = mediaPage.getAnyTitle();
                if (actualTitle.contains(Data.expectedTitleGallery) ||
                        actualTitle.contains(Data.expectedTitlePhotoGallery) ||
                        actualTitle.contains(Data.expectedTitleVideo) ||
                        actualTitle.contains(Data.expectedTitleAlbums)) {


                    System.out.println("Title is valid: " + actualTitle);
                }else{
                    Assert.fail("Title is not valid");
                }
            }
        }



}
