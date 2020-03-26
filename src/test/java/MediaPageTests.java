import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MediaPageTests extends BaseUI {
    String currentUrlMedia;



    @Test
    public void testMediaPage() {
        mediaPage.clickMediaPageLink();
        //Assert.assertEquals(currentUrlMedia, Data.expectedUrlMedia);
        softAssert.assertEquals(currentUrlMedia, Data.expectedUrlMedia,"Url is wrong");
        softAssert.assertAll();


    }

}
