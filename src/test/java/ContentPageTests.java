import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContentPageTests extends BaseUI {

String currentUrlContent;

    @Test
    public void testLinkButtonHowWeWork(){
        contentPage.testHowWeWorkLink();
        Assert.assertEquals(currentUrlContent,Data.expectedUrlContent);

    }
}
