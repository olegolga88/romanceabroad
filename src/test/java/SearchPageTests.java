import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchPageTests extends BaseUI {

    String currentUrlSearch;


    public static final boolean testCase11 = true;
    public static final boolean testCase12 = true;
    public static final boolean testCase13 = true;
    public static final boolean testCase14 = true;
    public static final boolean testCase15 = true;


    @Test (priority = 1,enabled = testCase11, groups = {"admin","user"})
    public void testDropDownListsSearchPageTestCase11() {
        searchPage.clickLinkSearch();
        driver.getCurrentUrl();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        //Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);
        //  For DropDawnList
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchPage.getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY, "name");
        searchPage.getDropDownListByIndex(Locators.DROP_DOWN_LIST_MIN_AGE, 0);
        searchPage.getDropDownListByText(Locators.DROP_DOWN_LIST_MAX_AGE, "32");
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
        Assert.assertTrue(driver.findElement(Locators.LINK_SEARCH).isDisplayed(), "Element is not displated");
        searchPage.clickLinkSearch();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        // Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);
        softAssert.assertEquals(currentUrlSearch, Data.expectedUrlSearch, "Url is wrong ");
        WebElement dropDownListSortBy = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.DROP_DOWN_LIST_SORT_BY));
        searchPage.getDropDownListByValue(dropDownListSortBy, "name");
        softAssert.assertAll();

    }

}



