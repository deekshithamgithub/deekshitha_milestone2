package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.HomePage;
import herokuapp.pages.InfiniteScrollPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InfiniteScrollTest extends BaseTest {

    @Test
    public void tc01_verifyInfiniteScrollLoadsContent() {
        HomePage home = new HomePage(driver);
        home.openModule("Infinite Scroll");

        InfiniteScrollPage page = new InfiniteScrollPage(driver);
        page.scrollDown();
        page.scrollDown();

        Assert.assertTrue(page.hasParagraphs());
    }
}
