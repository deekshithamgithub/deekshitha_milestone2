package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.ExitIntentPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExitIntentTest extends BaseTest {

    @Test
    public void tc01_verifyExitIntentModalAppears() {
        HomePage home = new HomePage(driver);
        home.openModule("Exit Intent");

        ExitIntentPage page = new ExitIntentPage(driver);
        page.triggerExitIntent();

        Assert.assertTrue(page.isModalDisplayed());
    }
}
