package com.romanceabroad.ui;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseUITestForSauceLabs {
    public WebDriver driver;
    WebDriverWait wait;
    public MainPage mainPage;
    SearchPage searchPage;
    BlogPage blogPage;
    BookTourPage bookTourPage;
    ContentPage contentPage;
    MediaPage mediaPage;
    StorePage storePage;
    SoftAssert softAssert= new SoftAssert();

    @BeforeMethod
    @Parameters()

}
