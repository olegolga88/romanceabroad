import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MediaTests extends BaseUI {
    String currentUrlMedia;



    @Test
    public void testMediaPage() {
        driver.findElement(Locators.LINK_MEDIA).click();
        driver.getCurrentUrl();
        currentUrlMedia = driver.getCurrentUrl();
        System.out.println(currentUrlMedia);
        //Assert.assertEquals(currentUrlMedia, Data.expectedUrlMedia);
        softAssert.assertEquals(currentUrlMedia, Data.expectedUrlMedia,"Url is wrong");
        softAssert.assertAll();

    }

}
