package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.GeolocationPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeolocationTest extends BaseTest {

    @Test
    public void tc01_verifyGeolocationShowsLat() {
        HomePage home = new HomePage(driver);
        home.openModule("Geolocation");

        GeolocationPage page = new GeolocationPage(driver);
        page.clickWhereAmI();

        Assert.assertTrue(page.getLatitude().length() > 0);
    }
}
