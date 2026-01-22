package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.HomePage;
import herokuapp.pages.InputsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest {

    @Test
    public void tc01_verifyInputsAcceptsNumber() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Inputs");

        InputsPage page = new InputsPage(driver);
        page.enterNumber("123");

        Assert.assertEquals(page.getValue(), "123");
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
