package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.DynamicLoadingExample2Page;
import herokuapp.pages.DynamicLoadingPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest {

    @Test
    public void tc01_verifyDynamicLoadingExample2() {
        try{
        HomePage home = new HomePage(driver);
        home.openModule("Dynamic Loading");

        DynamicLoadingPage loading = new DynamicLoadingPage(driver);
        loading.openExample2();

        DynamicLoadingExample2Page ex2 = new DynamicLoadingExample2Page(driver);
        ex2.clickStart();

        Assert.assertTrue(ex2.getFinishText().contains("Hello World!"));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
