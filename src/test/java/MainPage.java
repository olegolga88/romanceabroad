import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPage {
    String mainUrl = "https://romanceabroad.com/";
    WebDriver driver;
    String currentUrlSearch;
    String currentUrlMedia;
    String currentUrlStore;
    String currentUrlContent;
    String currentUrlBlog;
    String currentUrlBookNow;
    String expectedUrlSearch = "https://romanceabroad.com/users/search";
    String expectedUrlMedia = "https://romanceabroad.com/media/index";
    String expectedUrlStore = "https://romanceabroad.com/store/category-sweets";
    String expectedUrlContent = "https://romanceabroad.com/content/view/how-it-works";
    String expectedUrlBlog = "https://romanceabroad.com/content/view/blog";
    String expectedUrlBookNow ="https://romanceabroad.com/store/sweets/20-tour_to_ukraine";
    By Link_Search =By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    By Link_Media =By.cssSelector("a[href='https://romanceabroad.com/media/index']");
    By Link_Sign_In =By.xpath("//a[@href='https://romanceabroad.com/users/login_form']");
    By Button_Registration =By.xpath("//button[@id='show-registration-block']");
    By Link_Store = By.xpath("//a[@href =  'https://romanceabroad.com/store/category-sweets']");
    By Link_Content = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    By Link_Blog = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
    By Link_Book_Now = By.xpath("//a[contains(text(),'BOOK NOW')]");
    By Link_Request_Tur_Info = By.xpath("//a[@href='https://romanceabroad.com/REQUEST_TOUR_INFO+Application_Form.doc']");
int indexLinkSignIn=0;
int indexLinkRequestTurInfo=0;




    @BeforeMethod
public void setUp (){

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver() ;
    driver.manage() .window().maximize();
    driver.get(mainUrl);

}
 @Test
    public void testSearchPage() {
     driver.findElement(Link_Search).click();
     driver.getCurrentUrl();
     currentUrlSearch = driver.getCurrentUrl();
     System.out.println(currentUrlSearch);
     Assert.assertEquals(currentUrlSearch, expectedUrlSearch);

 }
 @Test
    public void testMediaPage() {
     driver.findElement(Link_Media).click();
     driver.getCurrentUrl();
     currentUrlMedia = driver.getCurrentUrl();
     System.out.println(currentUrlMedia);
     Assert.assertEquals(currentUrlMedia, expectedUrlMedia);
 }

        @Test
        public void testSignIn() {
        WebElement LinkSignIn = driver.findElement(Link_Sign_In);
            LinkSignIn.click();

 }
 @Test
        public void testRegistration() {
        driver.findElement(Button_Registration).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("11@gmail.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("11@gmail.com");
        driver.findElement(By.xpath("//button[@data-action='next-page'][text()='Next']")).click();



 }
 //Homwork #2
   //            //a[@href='https://romanceabroad.com/content/view/how-it-works']
   //              a[href='https://romanceabroad.com/content/view/how-it-works']
    //           //a[@href =  'https://romanceabroad.com/store/category-sweets']
    //             a[href =  'https://romanceabroad.com/store/category-sweets']
    //          button[@id='show-registration-block'
//             //a[@href = 'https://romanceabroad.com/media/index']
    //          a[href = 'https://romanceabroad.com/media/index']
    //          //a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'][text()='Tour to Ukraine']
//             //a[@href='https://romanceabroad.com/REQUEST_TOUR_INFO+Application_Form.doc'][text()='REQUEST TOUR INFO']
//             //a[@href="https://romanceabroad.com/content/view/blog"]
    //         //a[href="https://romanceabroad.com/content/view/blog"]
//             //a[@href='https://romanceabroad.com/content/view/how-it-works']
    //         //a[href='https://romanceabroad.com/content/view/how-it-works']
    //           a[href='https://romanceabroad.com/content/view/how-it-works']
    //          //a[@href='https://romanceabroad.com/content/view/blog']
    //           a[href='https://romanceabroad.com/content/view/blog']
    //          //a[@href="https://romanceabroad.com/REQUEST_TOUR_INFO+Application_Form.doc"]
// homwork #4

    @Test
    public void testStorePage(){
        driver.findElement(Link_Store).click();
        driver.getCurrentUrl();
        currentUrlStore = driver.getCurrentUrl();
        System.out.println(currentUrlStore);
        Assert.assertEquals(currentUrlStore, expectedUrlStore);
}
@Test
public void testContentPage(){
        driver.findElement(Link_Content).click();
    driver.getCurrentUrl();
    currentUrlContent = driver.getCurrentUrl();
    System.out.println(currentUrlContent);
    Assert.assertEquals(currentUrlContent, expectedUrlContent);
}

@Test
public void testBlogPage(){
        driver.findElement(Link_Blog).click();
    driver.getCurrentUrl();
    currentUrlBlog = driver.getCurrentUrl();
    System.out.println(currentUrlBlog);
    Assert.assertEquals(currentUrlBlog, expectedUrlBlog);
}
@Test
public void testBookNow(){
    driver.findElement(Link_Book_Now).click();
    driver.getCurrentUrl();
    currentUrlBookNow = driver.getCurrentUrl();
    System.out.println(currentUrlBookNow);
    Assert.assertEquals(currentUrlBookNow, expectedUrlBookNow);
}


    @Test
    public void testRequestTurInfo() {
        WebElement LinkRequestTurInfo = driver.findElement(Link_Request_Tur_Info);
        LinkRequestTurInfo.click();
    }



        @AfterMethod
        public void afterActions() {
            //driver.quit();

        }


    }