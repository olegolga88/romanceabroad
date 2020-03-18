import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BlogTests extends BaseUI {
    String currentUrlBlog;
    @Test
public void testBlogPage(){
        driver.findElement(Locators.LINK_BLOG).click();
   driver.getCurrentUrl();
    currentUrlBlog = driver.getCurrentUrl();
   System.out.println(currentUrlBlog);
   Assert.assertEquals(currentUrlBlog, Data.expectedUrlBlog);
}
    @Test
    public void test1() {
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='info-content-block wysiwyg']//li"));
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            driver.get("https://romanceabroad.com/content/view/blog");
            driver.findElement(Locators.LINK_BLOG).click();
            links = driver.findElements(By.xpath("//div[@class='info-content-block wysiwyg']//li"));
        }
    }
}
