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
        String expectedUrlPrettyWomen = "https://romanceabroad.com/users/search";
        String expectedTitleHowWeWork = "Ukrainian women for marriage";
        String expectedTitlePrettyWomen = "Single Ukrainian women online";
        String expectedTitlePhotos = "Ukrainian women photos";
        String expectedUrlPhotos = "https://romanceabroad.com/media/index";
        List<WebElement> links = driver.findElements(Locators.LIST_OF_BUTTONS);
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();

            if (info.contains("WORK")) {
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TITLE_OF_PAGE));
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                Assert.assertEquals(expectedTitleHowWeWork, actualTitle);
            }
            if (info.contains("PRETTY WOMEN")) {
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TITLE_OF_PAGE));
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPrettyWomen = driver.getCurrentUrl();
                Assert.assertEquals(expectedTitlePrettyWomen, actualTitle);
                Assert.assertEquals(actualUrlPrettyWomen, expectedUrlPrettyWomen);
                driver.findElement(By.xpath("//a[@class='g-pic-border g-rounded']")).isDisplayed();
            }
            if (info.contains("PHOTOS")) {
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TITLE_OF_PAGE));
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPhotos = driver.getCurrentUrl();
                Assert.assertEquals(expectedTitlePhotos, actualTitle);
                Assert.assertEquals(expectedUrlPhotos, actualUrlPhotos);
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
}
