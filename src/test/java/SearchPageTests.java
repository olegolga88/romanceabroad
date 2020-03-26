
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SearchPageTests extends BaseUI {
    String currentUrlSearch;


    @Test
    public void testSearchPage() {
        searchPage.clickLinkSearch();
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
        driver.findElement(Locators.BUTTON_SEARCH).click();
    }


}



