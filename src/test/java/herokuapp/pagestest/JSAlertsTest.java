package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.HomePage;
import herokuapp.pages.JSAlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSAlertsTest extends BaseTest {

    @Test
    public void tc01_verifyJSAlert() {
        HomePage home = new HomePage(driver);
        home.openModule("JavaScript Alerts");

        JSAlertsPage page = new JSAlertsPage(driver);
        page.clickJSAlert();

        driver.switchTo().alert().accept();

        Assert.assertTrue(page.getResult().contains("You successfully clicked an alert"));
    }
}
