import org.openqa.selenium.By;

public class Locators {

    //Media Page
    public static final By LINK_MEDIA =By.cssSelector("a[href='https://romanceabroad.com/media/index']");

    // Registration Page
    public static final By BUTTON_REGISTRATION =By.xpath("//button[@id='show-registration-block']");
    public static final By TEXT_FIELD_EMAIL= By.cssSelector("input#email");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("input#password");
    public static final By BUTTON_NEXT=  By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TEXT_FIELD_NICKNAME= By.cssSelector("#nickname");
    public static final By TEXT_FIELD_PHONE= By.cssSelector("input[name='data[phone]']");


    //Search Page
    public static final By LINK_SEARCH= By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By DROP_DOWN_LIST_SORT_BY= By.xpath("//div[@class='form-inline']//select");
    public static final By DROP_DOWN_LIST_MIN_AGE= By.xpath("//select[@id='age_min']");
    public static final By DROP_DOWN_LIST_MAX_AGE= By.xpath("//select[@id='age_max']");

    //Main Page
    public static final By VIDEO_FIELD= By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']");
    public static final By VIDEO_BUTTON= By.xpath("//button[@class='ytp-large-play-button ytp-button']");


}
