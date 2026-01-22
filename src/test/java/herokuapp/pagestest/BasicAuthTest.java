package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.BasicAuthPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {

    @Test
    public void tc01_verifyBasicAuth() {
        try{
        // Basic Auth requires credentials in URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        BasicAuthPage auth = new BasicAuthPage(driver);
        Assert.assertTrue(auth.getMessageText().contains("Congratulations"));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
