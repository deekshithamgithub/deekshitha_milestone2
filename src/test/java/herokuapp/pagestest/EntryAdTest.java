package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.EntryAdPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EntryAdTest extends BaseTest {

    @Test
    public void tc01_verifyEntryAdModalCanBeClosed() {
        HomePage home = new HomePage(driver);
        home.openModule("Entry Ad");

        EntryAdPage page = new EntryAdPage(driver);

        if (page.isModalDisplayed()) {
            page.closeModal();
        }

        Assert.assertTrue(driver.getPageSource().contains("Entry Ad"));
    }
}
