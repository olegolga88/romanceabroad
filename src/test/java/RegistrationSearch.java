import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class RegistrationSearch extends BaseUI{


 @Test
        public void testRegistration() {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration();
        mainPage.completeSecondPartOfRegistration();



        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(Data.Phone);
     WebElement checkboxConfirmation= driver.findElement(By.cssSelector("input#confirmation"));
     checkboxConfirmation.click();





 }
}