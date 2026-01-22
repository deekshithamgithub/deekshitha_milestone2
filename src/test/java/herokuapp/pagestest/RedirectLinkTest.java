package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.HomePage;
import herokuapp.pages.RedirectLinkPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RedirectLinkTest extends BaseTest {

    @Test
    public void tc01_verifyRedirectLinkNavigates() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Redirect Link");

        RedirectLinkPage page = new RedirectLinkPage(driver);
        page.clickRedirectLink();

        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes"));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
