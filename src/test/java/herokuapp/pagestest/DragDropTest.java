package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.DragDropPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest extends BaseTest {

    @Test
    public void tc01_verifyDragDropWorks() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Drag and Drop");

        DragDropPage page = new DragDropPage(driver);
        String before = page.getBoxAHeader();

        page.dragAtoB();

        String after = page.getBoxAHeader();
        Assert.assertNotEquals(after, before);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
