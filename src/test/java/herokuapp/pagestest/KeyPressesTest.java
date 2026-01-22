package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.HomePage;
import herokuapp.pages.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTest extends BaseTest {

    @Test
    public void tc01_verifyKeyPressResult() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Key Presses");

        KeyPressesPage page = new KeyPressesPage(driver);
        page.pressKey(Keys.ENTER);

        Assert.assertTrue(page.getResult().contains("ENTER"));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
