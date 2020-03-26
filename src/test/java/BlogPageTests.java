import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BlogPageTests extends BaseUI {

String currentUrl;
    @Test
    public void listOfElements() {
        blogPage.testBlogPageListOfElements1();
        Assert.assertEquals(currentUrl,Data.expectedUrlBlog);
        blogPage.testBlogPageListOfElements2();



        //for (int i = 0; i < links.size(); i++) {
        //    String info = links.get(i).getText();
        //    System.out.println(info);
        //    driver.get(Data.expectedUrlBlog);
        //    driver.findElement(Locators.LINK_BLOG).click();
        //   links = driver.findElements(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);
    }
}





