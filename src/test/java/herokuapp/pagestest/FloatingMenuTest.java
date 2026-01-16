package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.FloatingMenuPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuTest extends BaseTest {

    @Test
    public void tc01_verifyFloatingMenuVisibleAfterScroll() {
        HomePage home = new HomePage(driver);
        home.openModule("Floating Menu");

        FloatingMenuPage page = new FloatingMenuPage(driver);
        page.scrollDown();

        Assert.assertTrue(page.isMenuDisplayed());
    }
}
