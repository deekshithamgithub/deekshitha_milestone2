package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.BrokenImagePage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenImageTest extends BaseTest {

    @Test
    public void tc01_verifyBrokenImagesPageLoads() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Broken Images");

        BrokenImagePage page = new BrokenImagePage(driver);
        Assert.assertTrue(page.getImagesCount() > 0);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
