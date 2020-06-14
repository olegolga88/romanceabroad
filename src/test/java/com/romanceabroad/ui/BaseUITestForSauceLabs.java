package com.romanceabroad.ui;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

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
    @Parameters({"browser","version", "platform" })
    public void setup(String browser, String version, String platform, Method method) throws MalformedURLException {
        Reports.start(method.getName());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username","olegolga88");
        capabilities.setCapability("accessKey","Key");
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version", version);
        capabilities.setCapability("platform", platform);
        capabilities.setCapability("name", method.getName());
        driver= new RemoteWebDriver(
                new URL("http://" + System.getenv("SAUCE_USERNAME") +
                        System.getenv("SAUCE_ACCESS_KEY") +
                        "@ondemand.saucelabs.com:80/wd/hub"),capabilities);





        wait= new WebDriverWait(driver,20);
        mainPage = new MainPage (driver,wait);
        searchPage = new SearchPage(driver,wait);
        blogPage = new BlogPage(driver,wait);
        bookTourPage = new BookTourPage(driver,wait);
        storePage= new StorePage(driver,wait);
        contentPage= new ContentPage(driver,wait);
        mediaPage= new MediaPage(driver,wait);

        driver.manage() .window().maximize();
        driver.get(Data.mainUrl);


    }
    @AfterMethod
    public void afterActions(ITestResult testResult) {
        //Local reports
        if (testResult.getStatus() == ITestResult.FAILURE){
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();

        //SauceLabs reports
        ((JavascriptExecutor)driver).executeScript
                ("sauce:job-result=" + (testResult.isSuccess() ? "passed" : "failed"));
        driver.quit();

    }



}
