//package herokuapp.pagestest;
//
//import orangehrm.basetest.BaseTest;
//import org.testng.annotations.Test;
//
//public class ABTestingTest extends BaseTest {
//
//    @Test
//    public void abtestingTest(){
//        try{
//            System.out.println("testing");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.ABTesting;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ABTestingTest extends BaseTest {

    @Test
    public void tc01_verifyABTestingPage() {
        try{
        Reporter.log("ABTesting Test Started", true);

        HomePage home = new HomePage(driver);
        home.openModule("A/B Testing");

        ABTesting page = new ABTesting(driver);

        Assert.assertTrue(page.getHeadingText().contains("A/B Test"));
        Assert.assertTrue(page.isParagraphDisplayed());

        Reporter.log("ABTesting Test Completed", true);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

