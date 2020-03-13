import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class MainPageTests extends BaseUI {

    @Test
    public void test() throws InterruptedException {
        System.out.println("!!!!!!!");
        Thread.sleep(5000);
        WebElement video = driver.findElement(Locators.VIDEO_FIELD);
        driver.switchTo().frame(video);
        driver.findElement(Locators.VIDEO_BUTTON).click();
    }

    @Test
    public void test1() {
        List<WebElement> links = driver.findElements(Locators.LIST_OF_BUTTONS);
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            driver.get(Data.mainUrl);
            links = driver.findElements(Locators.LIST_OF_BUTTONS);
        }
    }

}
