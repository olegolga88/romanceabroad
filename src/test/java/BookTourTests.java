import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTourTests extends BaseUI {
    String currentUrlBookNow;
    @Test
     public void testBookNow(){
      driver.findElement(Locators.LINK_BOOK_NOW).click();
      driver.getCurrentUrl();
      currentUrlBookNow = driver.getCurrentUrl();
      System.out.println(currentUrlBookNow);

}
}
