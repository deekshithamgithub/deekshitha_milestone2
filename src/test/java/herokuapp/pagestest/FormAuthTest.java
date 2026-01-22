package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.FormAuthPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthTest extends BaseTest {

    @Test
    public void tc01_verifyValidLogin() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Form Authentication");

        FormAuthPage page = new FormAuthPage(driver);
        page.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(page.getFlashMessage().contains("You logged into a secure area!"));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
