package com.romanceabroad.ui;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseUI {
    public WebDriver driver;
    WebDriverWait wait;
    public MainPage mainPage;
    SearchPage searchPage;
    BlogPage blogPage;
    BookTourPage bookTourPage;
    ContentPage contentPage;
    MediaPage mediaPage;
    StorePage storePage;
    SoftAssert softAssert = new SoftAssert();
    protected TestBox testBox;

    protected enum TestBox {
        WEB, MOBILE, SAUCE
    }

    @BeforeMethod(groups = {"user", "admin", "ie"}, alwaysRun = true)
    @Parameters({"browser", "testBox", "platform","version", "deviceName"})
    public void setup(@Optional("chrome") String browser,
                      @Optional("web") String box,
                      @Optional("null") String platform,
                      @Optional("null") String version,
                      @Optional("null") String device,
                      Method method) throws MalformedURLException {
        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());

        if (box.equalsIgnoreCase("web")) {
            testBox = TestBox.WEB;
        } else if (box.equalsIgnoreCase("mobile")) {
            testBox = TestBox.MOBILE;
        } else if (box.equalsIgnoreCase("sauce")) {
            testBox = TestBox.SAUCE;
            switch (testBox) {
                case WEB:

                    // Check if parameter passed from TestNG is 'firefox'
                    if (browser.equalsIgnoreCase("firefox")) {
                        // Create firefox instance
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                    }
                    // Check if parameter passed as 'chrome'
                    else if (browser.equalsIgnoreCase("chrome")) {
                        // Set path to chromedriver.exe
                        WebDriverManager.chromedriver().setup();
                        // Create chrome instance
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");

                    } else if (browser.equalsIgnoreCase("IE")) {
                        WebDriverManager.iedriver().setup();
                        driver = new InternetExplorerDriver();
                        driver.manage().deleteAllCookies();

                    } else {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");
                    }
                    break;

                case MOBILE:
                    System.out.println("Mobile Chrome");
                    Map<String, String> mobileEmulation = new HashMap<String, String>();
                    mobileEmulation.put("deviceName", "Galaxy S5");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    driver.get("chrome://settings/clearBrowserData");
                    break;

                case SAUCE:
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("username", "olegolga88");
                    capabilities.setCapability("accessKey", "Key");
                    capabilities.setCapability("browserName", browser);
                    capabilities.setCapability("version", version);
                    capabilities.setCapability("platform", platform);
                    capabilities.setCapability("name", method.getName());
                    driver = new RemoteWebDriver(
                            new URL("http://" + System.getenv("SAUCE_USERNAME") +
                                    System.getenv("SAUCE_ACCESS_KEY") +
                                    "@ondemand.saucelabs.com:80/wd/hub"), capabilities);
                    break;

            }


            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            wait = new WebDriverWait(driver, 20);
            mainPage = new MainPage(driver, wait);
            searchPage = new SearchPage(driver, wait);
            blogPage = new BlogPage(driver, wait);
            bookTourPage = new BookTourPage(driver, wait);
            storePage = new StorePage(driver, wait);
            contentPage = new ContentPage(driver, wait);
            mediaPage = new MediaPage(driver, wait);

            driver.manage().window().maximize();
            driver.get(Data.mainUrl);


        }}

        @AfterMethod
        public void afterActions (ITestResult testResult){
            if (testResult.getStatus() == ITestResult.FAILURE) {
                Reports.fail(driver, testResult.getName());
            }
            Reports.stop();
            driver.quit();

        }


    }
