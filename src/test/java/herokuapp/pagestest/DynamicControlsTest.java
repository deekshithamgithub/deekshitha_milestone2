package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.DynamicControlsPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void tc01_verifyDynamicControlsRemove() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Dynamic Controls");

        DynamicControlsPage page = new DynamicControlsPage(driver);
        page.clickRemove();

        Assert.assertTrue(page.getMessage().contains("It's gone!"));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
