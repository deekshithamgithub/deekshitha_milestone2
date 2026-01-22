package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.ContextMenuPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test
    public void tc01_verifyContextMenuAlert() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Context Menu");

        ContextMenuPage page = new ContextMenuPage(driver);
        page.rightClickBox();

        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertTrue(alertText.contains("You selected a context menu"));
            } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
