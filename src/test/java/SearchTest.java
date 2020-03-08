import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.Locator;

import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseUI{
    String currentUrlSearch;



    @Test
    public void testSearchPage() {
        driver.findElement(Locators.LINK_SEARCH).click();
        driver.getCurrentUrl();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);


        // DropDawnList
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
                /*Select select= new Select(driver.findElement(By.xpath("//div[@class='form-inline']//select")));
        select.selectByVisibleText("Views");*/


                getDropDownListByIndex(Locators.DROP_DOWN_LIST_SORT_BY,3);
                getDropDownListByIndex(Locators.DROP_DOWN_LIST_MIN_AGE,0);
                getDropDownListByIndex(Locators.DROP_DOWN_LIST_MAX_AGE,10);
    }

    public void getDropDownListByIndex(By locator,int index) {
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);

    }
    }


