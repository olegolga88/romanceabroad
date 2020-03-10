import org.testng.Assert;
import org.testng.annotations.Test;

public class ContentPageTests extends BaseUI {
    String currentUrlContent;


    @Test
    public void testContentPage(){
        driver.findElement(Locators.LINK_CONTENT).click();
    driver.getCurrentUrl();
    currentUrlContent = driver.getCurrentUrl();
    System.out.println(currentUrlContent);
    Assert.assertEquals(currentUrlContent, Data.expectedUrlContent);
}

}
