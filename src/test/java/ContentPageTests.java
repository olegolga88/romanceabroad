import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class ContentPageTests extends BaseUI {

    String currentUrlContent;

    @Test
    public void testLinkButtonHowWeWork() {
        contentPage.clickLinkContent();
        currentUrlContent = driver.getCurrentUrl();
        System.out.println(currentUrlContent);
        Assert.assertEquals(currentUrlContent, Data.expectedUrlContent);

    }

    @Test
    public void testContactUsPage() {
        contentPage.clickLinkContent();
        contentPage.clickLinkContactUs();
        contentPage.completeContactUsForm(Data.reason, Data.yourName, Data.yourEmail, Data.subject,
                Data.massage, Data.captcha);


    }

    String nameOfArticle;
    String titleOfArticles;
String currentUrl;
    @Test
    public void testArticlesAndTitles() {
        contentPage.clickLinkContent();
            driver.getCurrentUrl();
            currentUrl = driver.getCurrentUrl();
            System.out.println(currentUrl);
            Assert.assertEquals(currentUrl,Data.expectedUrlContent);
            contentPage.clickContentMenu();
            contentPage.collectAllLinksOfArticles();

       List<WebElement> linksOfArticles = contentPage.collectAllLinksOfArticles();
        System.out.println(linksOfArticles.size());
        for (int i = 0; i < linksOfArticles.size(); i++) {
            WebElement link = linksOfArticles.get(i);
            nameOfArticle = link.getText();
            if (nameOfArticle.contains("How it works")) {
            } else if (nameOfArticle.contains("Kharkov dating agency")) {
            } else if (nameOfArticle.contains("Kiev dating agency")) {
            } else if (nameOfArticle.contains("Beautiful urkainian girls")) {
            } else if (nameOfArticle.contains("Real Ukrainian brides")) {
            } else if (nameOfArticle.contains("Eastern European women")) {
            } else if (nameOfArticle.contains("Marriage agency in Ukraine")) {
            } else if (nameOfArticle.contains("Kiev dating site")) {
            } else if (nameOfArticle.contains("Find Ukrainian girlfriend")) {
            } else if (nameOfArticle.contains("Slavic women for marriage")) {
            } else if (nameOfArticle.contains("How to marry Ukrainian lady")) {
            } else if (nameOfArticle.contains("Free Ukrainian dating site")) {
            } else if (nameOfArticle.contains("9 Factors to Keep in Mind When Dating a Ukrainian Woman")) {
            } else if (nameOfArticle.contains("Is There a Difference Between Dating or Courting a Ukrainian Woman?")) {

            } else {

                link.click();
                titleOfArticles = contentPage.getAnyTitle();
                Assert.assertEquals(nameOfArticle, titleOfArticles);
                contentPage.collectAllLinksOfArticles();

            }
        }

    }
}
