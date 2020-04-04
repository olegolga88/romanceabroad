import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Locators {

    //Media Page
    public static final By LINK_MEDIA = By.cssSelector("a[href='https://romanceabroad.com/media/index']");
public static final By BUTTON_ALL = By.xpath("//a[@href='https://romanceabroad.com/media/all']");
 public static final By BUTTON_PHOTO= By.xpath("//a[@href='https://romanceabroad.com/media/photo']");
public static final By BUTTON_ALBUMS= By.xpath("//a[@href='https://romanceabroad.com/media/albums']");
public static final By BUTTON_VIDEO= By.xpath("//a[@href='https://romanceabroad.com/media/video']");
public static final By LIST_OF_BUTTONS_MEDIA=By.xpath("//ul[@class='b-tabs']//li");
    // MainPage-Registration
    public static final By BUTTON_REGISTRATION = By.xpath("//button[@id='show-registration-block']");
    public static final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("input#password");
    public static final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TEXT_FIELD_NICKNAME = By.cssSelector("#nickname");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");
    public static final By BUTTON_DAY_BIRTH_DATE_FIELD = By.cssSelector("#daySelect");
    public static final By DROP_DOWN_LIST_SELECT_DAY = By.xpath("//li[@data-handler='selectDay']//a[text()='2']");
    public static final By BUTTON_MONTH_BIRTH_DATE_FIELD = By.cssSelector("#monthSelect");
    public static final By DROP_DOWN_LIST_SELECT_MONTH = By.xpath("//li[@data-handler='selectMonth']//a[text()='May']");
    public static final By BUTTON_YEAR_BIRTH_DATE_FIELD = By.cssSelector("#yearSelect");
    public static final By DROP_DOWN_LIST_SELECT_YEAR = By.xpath("//li[@data-handler='selectYear']//a[text()='2001']");
    public static final By TEXT_FIELD_LOCATION = By.cssSelector("input[name='region_name']");
    public static final By CHECK_BOX_CONFIRMATION = By.cssSelector("input#confirmation");


    //Search Page
    public static final By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By DROP_DOWN_LIST_SORT_BY = By.xpath("//div[@class='form-inline']//select");
    public static final By DROP_DOWN_LIST_MIN_AGE = By.xpath("//select[@id='age_min']");
    public static final By DROP_DOWN_LIST_MAX_AGE = By.xpath("//select[@id='age_max']");
    public static final By BUTTON_SEARCH = By.xpath("//input[@name='main_search_button']");
    public static final By BUTTON_GALLERY_VIEW= By.xpath("//a[@href='javascript:void(0);'][@title='Gallery view']");
public static final By DROP_DOWN_LIST_BUTTON_MIN_AGE=By.xpath("//div[@class='col-xs-5 no-padding-left']//select[@id='age_min']");
public static final By GIFT_BUTTON_SEARCH_PAGE= By.xpath("//div[@class='ssil1']//i");
public static final By BUTTON_FIND_PEOPLE_SEARCH_PAGE= By.xpath("//header[@id='main-menu-container']//button[@id='main_search_button_user_line']");
public static final By BUTTON_LOGIN_SEARCH_PAGE= By.xpath("//header[@id='main-menu-container']//a[@id='ajax_login_link']");
public static final By BUTTON_HELP_FOOTER_SEARCH_PAGE= By.xpath("//footer//div//div[@data-id='footer-menu-title-0']");
    public static final By BUTTON_ABOUT_FOOTER_SEARCH_PAGE= By.xpath("//footer//div//div[@data-id='footer-menu-title-1']");






    //Main Page
    public static final By VIDEO_FIELD = By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']");
    public static final By VIDEO_BUTTON = By.xpath("//button[@class='ytp-large-play-button ytp-button']");
    public static final By LIST_OF_BUTTONS = By.xpath("//ul[@class='navbar-nav']//li");
    public static final By TITLE_OF_PAGE = By.xpath("//h1");
    public static final By IMAGES_ON_MEDIA_PAGE = By.xpath("//a[@class='g-pic-border g-rounded']");
    public static final By LINK_SIGN_IN = By.xpath("//a[@data-action='show-registration-block']");
    //StorePage
    public static final By LINK_STORE = By.xpath("//a[@href =  'https://romanceabroad.com/store/category-sweets']");


    //ContentPage HowItWorks
    public static final By LINK_CONTENT = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By INFO_MENU_BUTTON_ADVERTISING=By.xpath("//ul//li//a[@href='https://romanceabroad.com/content/view/advertising']");
    public static final By SLIDE_MENU_BUTTON= By.xpath("//header[@id='main-menu-container']//a[@data-slidemenu='#slidemenu']");




    // BlogPage
    public static final By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
    public static final By LEFT_MENU_BLOG_PAGE = By.xpath("//div[@class='inside account_menu']");
    public static final By LIST_OF_ELEMENTS_BLOG_PAGE = By.xpath("//div[@class='inside account_menu']//ul//li//a");

//BookTourTests

    public static final By LINK_BOOK_NOW = By.xpath("//a[@href='https://romanceabroad.com/REQUEST_TOUR_INFO+Application_Form.doc']");


}
