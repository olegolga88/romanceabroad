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

    @BeforeMethod
    public void setUp (){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver() ;
        wait= new WebDriverWait(driver,20);
        mainPage = new MainPage (driver,wait);
        searchPage = new SearchPage(driver,wait);
        driver.manage() .window().maximize();
        driver.get(mainUrl);

    }
    @AfterMethod
    public void afterActions() {
        //driver.quit();

    }



}
// String currentUrlStore;
//    String currentUrlContent;
//    String currentUrlBlog;
//    String currentUrlBookNow;
//String expectedUrlStore = "https://romanceabroad.com/store/category-sweets";
//    String expectedUrlContent = "https://romanceabroad.com/content/view/how-it-works";
//    String expectedUrlBlog = "https://romanceabroad.com/content/view/blog";
//    String expectedUrlBookNow ="https://romanceabroad.com/store/sweets/20-tour_to_ukraine";
// By Link_Store = By.xpath("//a[@href =  'https://romanceabroad.com/store/category-sweets']");
//    By Link_Content =
//    By Link_Blog =
//    By Link_Book_Now = By.xpath("//a[contains(text(),'BOOK NOW')]");
//    By Link_Request_Tur_Info = By.xpath("//a[@href='https://romanceabroad.com/REQUEST_TOUR_INFO+Application_Form.doc']");
//int indexLinkSignIn=0;
//int indexLinkRequestTurInfo=0;




//@Test
//    public void testStorePage(){
//        driver.findElement(Link_Store).click();
//        driver.getCurrentUrl();
//        currentUrlStore = driver.getCurrentUrl();
//        System.out.println(currentUrlStore);
//        Assert.assertEquals(currentUrlStore, expectedUrlStore);
//}
//@Test
//public void testContentPage(){
//        driver.findElement(Link_Content).click();
//    driver.getCurrentUrl();
//    currentUrlContent = driver.getCurrentUrl();
//    System.out.println(currentUrlContent);
//    Assert.assertEquals(currentUrlContent, expectedUrlContent);
//}
//
//@Test
//public void testBlogPage(){
//        driver.findElement(Link_Blog).click();
//    driver.getCurrentUrl();
//    currentUrlBlog = driver.getCurrentUrl();
//    System.out.println(currentUrlBlog);
//    Assert.assertEquals(currentUrlBlog, expectedUrlBlog);
//}
//@Test
//public void testBookNow(){
//    driver.findElement(Link_Book_Now).click();
//    driver.getCurrentUrl();
//    currentUrlBookNow = driver.getCurrentUrl();
//    System.out.println(currentUrlBookNow);
//    Assert.assertEquals(currentUrlBookNow, expectedUrlBookNow);