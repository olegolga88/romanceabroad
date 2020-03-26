import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BaseActions {
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    String currentUrlSearch;

    public void clickLinkSearch() {
        driver.findElement(Locators.LINK_SEARCH).click();
        driver.getCurrentUrl();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
    }
}
