import org.testng.Assert;
import org.testng.annotations.Test;

public class BlogPageTests extends BaseUI {

String currentUrl;
    @Test
    public void listOfElements() {
        blogPage.clickLinkBlog();
        Assert.assertEquals(currentUrl,Data.expectedUrlBlog);
        blogPage.testBlogPageListOfElements();




    }
}





