import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContentPageTests extends BaseUI {
    String currentUrlContent;


    @Test
    public void testContentPage(){
        driver.findElement(Locators.LINK_CONTENT).click();
    driver.getCurrentUrl();
    currentUrlContent = driver.getCurrentUrl();
    System.out.println(currentUrlContent);
    Assert.assertEquals(currentUrlContent, Data.expectedUrlContent);



        List<WebElement> links = driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li"));
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            driver.get(Data.expectedUrlContent);
            links = driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li"));
        }
    }
}
