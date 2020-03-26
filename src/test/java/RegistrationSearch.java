import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationSearch extends BaseUI{


 @Test
        public void testRegistration() {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration();
        mainPage.completeSecondPartOfRegistration();

     WebElement checkboxConfirmation= driver.findElement(Locators.CHECK_BOX_CONFIRMATION);
     if(!checkboxConfirmation.isSelected()){
         checkboxConfirmation.click();
         System.out.println("Checkbox is selected");
     }else {
         Assert.fail("Checkbox is already selected!");
     }
 }
}


//Method for checkbox if it is checked
 /*@Test
   public void test6() {
        mainPage.clickJoinButton();
       mainPage.completeFirstPartOfRegistration();
       mainPage.completeSecondPartOfRegistration();

       WebElement checkbox=driver.findElement(Locators.CHECK_BOX_CONFIRMATION);
       if(!checkbox.isSelected()){
           checkbox.click();
           System.out.println("Checkbox is selected");
        }
  }*/




