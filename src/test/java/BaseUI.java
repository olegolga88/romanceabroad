import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUI {
    WebDriver driver;
    WebDriverWait wait;
    String mainUrl = "https://romanceabroad.com/";
    MainPage mainPage;
    SearchPage searchPage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp (){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver() ;
        wait= new WebDriverWait(driver,20);
        mainPage = new MainPage (driver,wait);
        searchPage = new SearchPage(driver,wait);
        registrationPage = new RegistrationPage(driver,wait);
        driver.manage() .window().maximize();
        driver.get(mainUrl);

    }
    @AfterMethod
    public void afterActions() {
        //driver.quit();

    }

    public static String generateNewNumber (String name, int length){
        return name + RandomStringUtils.random(length, "1729847557");
    }

}