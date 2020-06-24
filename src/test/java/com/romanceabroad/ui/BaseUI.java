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
    protected TestBrowser testBrowser;

    protected String valueOfBox;

    protected enum TestBox {
        WEB, MOBILE, SAUCE
    }

    protected enum TestBrowser {
        CHROME, FIREFOX, IE
    }

    @BeforeMethod(groups = {"user", "admin", "ie"}, alwaysRun = true)
    @Parameters({"browser", "testBox", "platform", "version", "deviceName", "testEnv"})
    public void setup(@Optional("chrome") String browser,
                      @Optional("web") String box,
                      @Optional("null") String platform,
                      @Optional("null") String version,
                      @Optional("null") String device,
                      @Optional("qa") String env,
                      Method method) throws MalformedURLException {
        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());

        if (box.equalsIgnoreCase("web")) {
            testBox = TestBox.WEB;
        } else if (box.equalsIgnoreCase("mobile")) {
            testBox = TestBox.MOBILE;
        } else if (box.equalsIgnoreCase("sauce")) {
            testBox = TestBox.SAUCE;
        }
        if (browser.equalsIgnoreCase("chrome")) {
            testBrowser = TestBrowser.CHROME;
        } else if (browser.equalsIgnoreCase("firefox")) {
            testBrowser = TestBrowser.FIREFOX;
        } else if (browser.equalsIgnoreCase("ie")) {
            testBrowser = TestBrowser.IE;
        }

        switch (testBox) {
            case WEB:
                switch (testBrowser) {
                    case FIREFOX:
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;

                    case CHROME:
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");
                        break;

                    case IE:
                        WebDriverManager.iedriver().setup();
                        driver = new InternetExplorerDriver();
                        driver.manage().deleteAllCookies();
                        break;

                    default:
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");
                        break;
                }

                driver.manage().window().maximize();
                break;

            case MOBILE:
                switch (testBrowser) {

                    case CHROME:
                        System.out.println("Mobile Chrome");
                        Map<String, String> mobileEmulation = new HashMap<String, String>();
                        mobileEmulation.put("deviceName", "Galaxy Note 3");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver(chromeOptions);
                        driver.get("chrome://settings/clearBrowserData");
                        break;
                }
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
        //driver.manage().window().maximize();

        if (env.contains("qa")) {
            driver.get(Data.mainUrl);
        } else if (env.contains("uat")) {
            driver.get("https://www.google.com/");
        } else if (env.contains("prod")) {
            driver.get("https://www.yahoo.com/");
        }
        valueOfBox = box;

    }

    @AfterMethod
    public void afterActions(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();
        //driver.quit();

    }


}
