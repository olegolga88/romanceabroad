
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SearchTest extends BaseUI{
    String currentUrlSearch;





    @Test
    public void testSearchPage() {
        driver.findElement(Locators.LINK_SEARCH).click();
        driver.getCurrentUrl();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);


        //  For DropDawnList
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
                /*Select select= new Select(driver.findElement(By.xpath("//div[@class='form-inline']//select")));
        select.selectByVisibleText("Views");*/


                searchPage.getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY,"name");
                searchPage.getDropDownListByIndex(Locators.DROP_DOWN_LIST_MIN_AGE,0);
                searchPage.getDropDownListByIndex(Locators.DROP_DOWN_LIST_MAX_AGE,10);
    }


    }



