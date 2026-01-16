package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.HomePage;
import herokuapp.pages.NotificationMessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessagesTest extends BaseTest {

    @Test
    public void tc01_verifyNotificationMessageShows() {
        HomePage home = new HomePage(driver);
        home.openModule("Notification Messages");

        NotificationMessagesPage page = new NotificationMessagesPage(driver);
        page.clickNotification();

        Assert.assertTrue(page.getMessage().length() > 0);
    }
}
