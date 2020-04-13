import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainPageTests extends BaseUI {
    @DataProvider(name ="Registration")
    public static Object[][] testRegistration2() throws Exception{
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("Registration.csv")).stream().forEach(s-> {
            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5],
                    data[6], data[7]});
        });
        return out.toArray(new Object[out.size()][]);
    }
    @Test (dataProvider ="Registration" )
    public void testRegistration() {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(Data.email,Data.password);
        mainPage.completeSecondPartOfRegistration(mainPage.generateNewNumber(Data.nickname,5),Data.day,
                Data.month, Data.year, Data.phone,Data.location,Data.city);

        WebElement checkboxConfirmation= driver.findElement(Locators.CHECK_BOX_CONFIRMATION);
        if(!checkboxConfirmation.isSelected()){
            checkboxConfirmation.click();
            System.out.println("Checkbox is selected");
        }else {
            Assert.fail("Checkbox is already selected!");
        }
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("!!!!!!!");
        Thread.sleep(5000);
        WebElement video = driver.findElement(Locators.VIDEO_FIELD);
        driver.switchTo().frame(video);
        driver.findElement(Locators.VIDEO_BUTTON).click();
    }
    @Test
    public void smokeTestMainPage() {
        List<WebElement> mainTabs = driver.findElements(Locators.LIST_OF_BUTTONS);
        System.out.println(mainTabs.size());

        for (int i = 0; i < mainTabs.size(); i++) {
             mainTabs.get(i).click();
          driver.get(Data.mainUrl);
            mainTabs = driver.findElements(Locators.LIST_OF_BUTTONS);

        }

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
            links.get(i).click();
            //mainPage.ajaxClick(links.get(i));

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

        mainPage.ajaxClick(Locators.LINK_SIGN_IN, 0);
    }

    @Test
    public void test4() {

        mainPage.ajaxClick(Locators.LIST_OF_BUTTONS, 3);


    }
@Test
    public void testLinksOnMainPage(){
        mainPage.checkLinksOnWebPage("//a","href");
    mainPage.checkLinksOnWebPage("//img","src");
    driver.findElement(Locators.LINK_SEARCH);
    mainPage.checkLinksOnWebPage("//a","href");
    mainPage.checkLinksOnWebPage("//img","src");
    }
}

