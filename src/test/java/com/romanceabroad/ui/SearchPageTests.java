package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.romanceabroad.ui.Locators.DROP_DOWN_LIST_MAX_AGE;


public class SearchPageTests extends BaseUI {

    public static final boolean testCase11 = true;
    public static final boolean testCase12 = true;
    public static final boolean testCase13 = true;
    public static final boolean testCase14 = true;
    public static final boolean testCase15 = true;
    public static final boolean testCase16 = true;
    String currentUrlSearch;

    @Test (priority = 1,enabled = testCase11, groups = {"admin","user"})
    public void testDropDownListsSearchPageTestCase11() {
        searchPage.clickLinkSearch();
        driver.getCurrentUrl();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        //Assert.assertEquals(currentUrlSearch, com.romanceabroad.ui.Data.expectedUrlSearch);
        //  For DropDawnList
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchPage.getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY, "name");
        searchPage.getDropDownListByIndex(Locators.DROP_DOWN_LIST_MIN_AGE, 0);
        searchPage.getDropDownListByText(DROP_DOWN_LIST_MAX_AGE,"32");
        searchPage.clickButtonSearch();
    }

    @Test(priority = 2,enabled = testCase12, groups = {"admin","user"})
    public void selectRandomDropDownListTestCase12() {
        searchPage.clickLinkSearch();
        for (int i = 0; i < 10; i++) {
            searchPage.selectItemDropDownRandomOption(Locators.DROP_DOWN_LIST_SORT_BY, "Sort By");
            searchPage.javaWaitSec(3);
        }
    }

    @Test(priority = 3,enabled = testCase13, groups = {"admin","user"})
    public void sizeOfDropDownListTestCase13() {
        searchPage.clickLinkSearch();
        int sizeOfDropDownListSortBy = searchPage.getSizeDropDownList(Locators.DROP_DOWN_LIST_SORT_BY);
        System.out.println(sizeOfDropDownListSortBy);
        for (int i = 0; i < sizeOfDropDownListSortBy; i++) {
            searchPage.selectItemDropDownRandomOption(Locators.DROP_DOWN_LIST_SORT_BY, "Sort By");
            mainPage.javaWaitSec(3);
        }
    }

    @Test(priority = 4,enabled = testCase14, groups = {"admin","user"})
    public void sizeOfDropDownListMinAgeTestCase14() {
        searchPage.clickLinkSearch();

        int sizeOfDropDownListSortBy = searchPage.getSizeDropDownList(Locators.DROP_DOWN_LIST_MIN_AGE);
        System.out.println(sizeOfDropDownListSortBy);
        for (int i = 0; i < sizeOfDropDownListSortBy; i++) {
            searchPage.selectItemDropDownRandomOption((Locators.DROP_DOWN_LIST_MIN_AGE), "Min Age");
            mainPage.javaWaitSec(3);
        }
    }

    @Test(priority = 5,enabled = testCase15, groups = {"admin","user"})
    public void testSearchPageTestCase15() {
        Assert.assertTrue(driver.findElement(Locators.LINK_SEARCH).isDisplayed(), "Element is not displayed");
        searchPage.clickLinkSearch();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        // Assert.assertEquals(currentUrlSearch, com.romanceabroad.ui.Data.expectedUrlSearch);
        softAssert.assertEquals(currentUrlSearch, Data.expectedUrlSearch, "Url is wrong ");
        searchPage.javaWaitSec(3);
        WebElement dropDownListSortBy = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY);
        searchPage.getDropDownListByValue(dropDownListSortBy, "name");
        softAssert.assertAll();

    }
@Test(dataProvider = "Search",dataProviderClass = DataProviders.class,priority = 6,enabled = testCase16, groups = {"admin","user"})
    public void searchDifferentResults(String minAge, String maxAge, String sortBy){
        int min= Integer.parseInt(minAge);
        int max=Integer.parseInt(maxAge);
    System.out.println(min);
    System.out.println(max);
        searchPage.clickLinkSearch();
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_MIN_AGE),minAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_MAX_AGE),maxAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY),sortBy);
searchPage.clickButtonSearch();

    List<WebElement> infoAboutUser=driver.findElements(Locators.INFO_ABOUT_USER);

    for (int i = 0; i < infoAboutUser.size() ; i++) {
        WebElement text=infoAboutUser.get(i);
       // searchPage.ajaxClick(text);
        String info=infoAboutUser.get(i).getText();
        System.out.println(info);
        infoAboutUser=driver.findElements(Locators.INFO_ABOUT_USER);
    }
}

}


