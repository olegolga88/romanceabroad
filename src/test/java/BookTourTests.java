import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTourTests extends BaseUI {

    String currentUrlBookNow;

    @Test
    public void testBookNowButton() {
        bookTourPage.testBookNow();
        Assert.assertEquals(currentUrlBookNow, Data.expectedUrlBookNow);

    }
}

