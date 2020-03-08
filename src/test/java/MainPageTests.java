import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MainPageTests extends BaseUI {
    BaseActions baseActions=new BaseActions(driver,wait);

    @Test
    public void test() throws InterruptedException{

        Thread.sleep(5000);
        WebElement video= driver.findElement(Locators.VIDEO_FIELD);
        driver.switchTo().frame(video);
        driver.findElement(Locators.VIDEO_BUTTON).click();
    }
}
