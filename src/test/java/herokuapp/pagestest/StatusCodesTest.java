package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.HomePage;
import herokuapp.pages.StatusCodesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StatusCodesTest extends BaseTest {

    @Test
    public void tc01_verifyStatusCode404() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Status Codes");

        StatusCodesPage status = new StatusCodesPage(driver);
        status.open404();

        Assert.assertTrue(driver.getPageSource().contains("This page returned a 404 status code"));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
