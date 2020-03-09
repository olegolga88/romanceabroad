import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActions {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseActions (WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }
    public static String generateNewNumber (String name, int length){
        return name + RandomStringUtils.random(length, "1729847557");
    }

    public void getDropDownListByIndex(By locator, int index) {
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
}
    public void getDropDownListByText(By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
}
    public void getDropDownListByValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }
}
