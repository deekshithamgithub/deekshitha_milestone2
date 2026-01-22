package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.ForgotPasswordPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void tc01_verifyForgotPasswordSubmit() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Forgot Password");

        ForgotPasswordPage page = new ForgotPasswordPage(driver);
        page.enterEmail("test@gmail.com");
        page.clickRetrievePassword();

        Assert.assertTrue(driver.getPageSource().contains("Your e-mail's been sent!"));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
