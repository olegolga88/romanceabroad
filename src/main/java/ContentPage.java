import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContentPage extends BaseActions {
    public ContentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    String currentUrlContent;

    public void testHowWeWorkLink() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_CONTENT));
        driver.findElement(Locators.LINK_CONTENT);
        driver.getCurrentUrl();
        currentUrlContent = driver.getCurrentUrl();
        System.out.println(currentUrlContent);


    }
}
