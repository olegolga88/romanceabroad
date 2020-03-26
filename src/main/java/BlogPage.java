import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BlogPage extends BaseActions {

    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    String currentUrl;

    public void testBlogPageListOfElements1() {

        driver.findElement(Locators.LINK_BLOG).click();
        driver.getCurrentUrl();
        currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
    }
    public void testBlogPageListOfElements2() {
        ajaxClick(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);
        List<WebElement> links = driver.findElements(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            System.out.println(i);
            String info = links.get(i).getText();
            System.out.println(info);
            ajaxClick(links.get(i));
            ajaxClick(Locators.LEFT_MENU_BLOG_PAGE);
            links = driver.findElements(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);


        }

    }
}





