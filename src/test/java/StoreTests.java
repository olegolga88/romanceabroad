import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreTests extends BaseUI {
    String currentUrlStore;

    @Test
    public void testStorePage() {
        driver.findElement(Locators.LINK_STORE).click();
        driver.getCurrentUrl();
        currentUrlStore = driver.getCurrentUrl();
        System.out.println(currentUrlStore);
        Assert.assertEquals(currentUrlStore, Data.expectedUrlStore);

    }
}
