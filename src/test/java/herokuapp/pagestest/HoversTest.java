package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.HomePage;
import herokuapp.pages.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTest extends BaseTest {

    @Test
    public void tc01_verifyHoverShowsProfileLink() {
        HomePage home = new HomePage(driver);
        home.openModule("Hovers");

        HoversPage page = new HoversPage(driver);
        page.hoverFirstUser();

        Assert.assertTrue(page.isViewProfileVisible());
    }
}
