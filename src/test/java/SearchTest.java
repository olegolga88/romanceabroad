import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseUI{
    String currentUrlSearch;



    @Test
    public void testSearchPage() {
        driver.findElement(Locators.LINK_SEARCH).click();
        driver.getCurrentUrl();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);

    }

}
