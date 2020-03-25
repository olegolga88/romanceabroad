import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainPageTests extends BaseUI {

    @Test
    public void test() throws InterruptedException {
        System.out.println("!!!!!!!");
        Thread.sleep(5000);
        WebElement video = driver.findElement(Locators.VIDEO_FIELD);
        driver.switchTo().frame(video);
        driver.findElement(Locators.VIDEO_BUTTON).click();
    }

    @Test
    public void test1() {
        String actualTitle;
        String actualUrlPrettyWomen;
        String actualUrlPhotos;





        List<WebElement> links = driver.findElements(Locators.LIST_OF_BUTTONS);
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            //links.get(i).click();
            mainPage.ajaxClick(links.get(i));

            if (info.contains("WORK")) {
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TITLE_OF_PAGE));
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                Assert.assertEquals(Data.expectedTitleHowWeWork, actualTitle);
            }
            if (info.contains("PRETTY WOMEN")) {
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TITLE_OF_PAGE));
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPrettyWomen = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitlePrettyWomen, actualTitle);
                Assert.assertEquals(actualUrlPrettyWomen, Data.expectedUrlPrettyWomen);
                driver.findElement(Locators.IMAGES_ON_MEDIA_PAGE).isDisplayed();
                if (actualUrlPrettyWomen.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special character. It is good url");
                }
            }
            if (info.contains("PHOTOS")) {
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TITLE_OF_PAGE));
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPhotos = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitlePhotos, actualTitle);
                Assert.assertEquals(Data.expectedUrlPhotos, actualUrlPhotos);
            }
            driver.get(Data.mainUrl);
            links = driver.findElements(Locators.LIST_OF_BUTTONS);
        }
    }

    @Test
    public void test2() {
        WebElement tabSearch = driver.findElement(Locators.LINK_SEARCH);
        if (tabSearch.isDisplayed()) {
            tabSearch.click();
        } else {
            Assert.fail("We can't find PRETTY WOMEN tab");
        }
    }

    @Test
    public void test3() {
        By linkSignIn = By.xpath("//a[@data-action='show-registration-block']");
////div[@class='col-lg-12 text-center']//a[@href='#']
        mainPage.ajaxClick(linkSignIn, 0);
    }

    @Test
    public void test4() {

        mainPage.ajaxClick(Locators.LIST_OF_BUTTONS, 3);


    }
}

