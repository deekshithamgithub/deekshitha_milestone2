package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.HomePage;
import herokuapp.pages.MultipleWindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsTest extends BaseTest {

    @Test
    public void tc01_verifyMultipleWindows() {
        HomePage home = new HomePage(driver);
        home.openModule("Multiple Windows");

        MultipleWindowsPage page = new MultipleWindowsPage(driver);
        String parent = driver.getWindowHandle();

        page.openNewWindow();

        Set<String> handles = driver.getWindowHandles();
        for (String h : handles) {
            if (!h.equals(parent)) {
                driver.switchTo().window(h);
            }
        }

        Assert.assertTrue(driver.getTitle().contains("New Window"));
        driver.close();
        driver.switchTo().window(parent);
    }
}
