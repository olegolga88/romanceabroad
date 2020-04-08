import org.openqa.selenium.WebElement;
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

    @Test
    public void testArticlesAndTitles() {
        contentPage.clickLinkContent();
        List<WebElement> linksOfArticles = contentPage.collectAllLinksOfArticles();
        System.out.println(linksOfArticles.size());
        for (int i = 0; i < linksOfArticles.size(); i++) {
            WebElement link = linksOfArticles.get(i);
            nameOfArticle = link.getText();
            if (nameOfArticle.contains("How it works")) {
            } else if (nameOfArticle.contains("Kharkov dating agency")) {
            } else if (nameOfArticle.contains("Kiev dating agency")) {
            } else {
                link.click();
                titleOfArticles = contentPage.getAnyTitle();
                Assert.assertEquals(nameOfArticle, titleOfArticles);
                linksOfArticles = contentPage.collectAllLinksOfArticles();


            }
        }

    }
}
