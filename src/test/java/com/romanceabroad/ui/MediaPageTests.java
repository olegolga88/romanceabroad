package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class MediaPageTests extends BaseUI {
    String currentUrlMedia;



    @Test
    public void testMediaPage() {
        mediaPage.clickMediaPageLink();
        currentUrlMedia = driver.getCurrentUrl();
        System.out.println(currentUrlMedia);
        //Assert.assertEquals(currentUrlMedia, com.romanceabroad.ui.Data.expectedUrlMedia);
        softAssert.assertEquals(currentUrlMedia, Data.expectedUrlMedia,"Url is wrong");
        softAssert.assertAll();


    }
    @Test
    public void testListOfButtonsMedia(){
        driver.findElement(Locators.LINK_MEDIA).click();
        currentUrlMedia=driver.getCurrentUrl();
        System.out.println(currentUrlMedia);

        List<WebElement> links=driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        System.out.println(links.size());

        for (int i = 0; i <links.size() ; i++) {
            String info=links.get(i).getText();
            System.out.println(info);
            mediaPage.ajaxClick(links.get(i));
            driver.get(currentUrlMedia);
            links=driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);


        }

    }

}
