package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class GeolocationPage {

    private static final Logger log = LogManager.getLogger(GeolocationPage.class);
    private WebDriver driver;

    public GeolocationPage(WebDriver driver) {
        Reporter.log("Initializing GeolocationPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "button")
    private WebElement whereAmIBtn;

    @FindBy(id = "lat-value")
    private WebElement lat;

    public void clickWhereAmI() {
        Reporter.log("Clicking Where am I", true);
        WaitUtil.waitForClick(driver, whereAmIBtn);
        whereAmIBtn.click();
        log.info("Clicked where am I");
    }

    public String getLatitude() {
        WaitUtil.waitForVisibility(driver, lat);
        return lat.getText();
    }
}
