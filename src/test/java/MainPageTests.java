import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MainPageTests extends BaseUI {

    @Test
    public void test() throws InterruptedException{
        System.out.println("!!!!!!!");
        Thread.sleep(5000);
        WebElement video= driver.findElement(Locators.VIDEO_FIELD);
        driver.switchTo().frame(video);
        driver.findElement(Locators.VIDEO_BUTTON).click();
    }
}
