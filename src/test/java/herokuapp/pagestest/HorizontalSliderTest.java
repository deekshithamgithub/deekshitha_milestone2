package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.HomePage;
import herokuapp.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void tc01_verifySliderMoves() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Horizontal Slider");

        HorizontalSliderPage page = new HorizontalSliderPage(driver);
        page.moveSliderRight(5);

        Assert.assertNotEquals(page.getSliderValue(), "0");
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
