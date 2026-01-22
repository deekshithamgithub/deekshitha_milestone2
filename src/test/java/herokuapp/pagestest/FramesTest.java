package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.FramesPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    public void tc01_verifyIFrameTyping() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Frames");
        home.openModule("iFrame");

        FramesPage frame = new FramesPage(driver);
        frame.setTextUsingJS("Hello Herokuapp Frame");

        Assert.assertEquals(frame.getEditorText(), "Hello Herokuapp Frame");
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
