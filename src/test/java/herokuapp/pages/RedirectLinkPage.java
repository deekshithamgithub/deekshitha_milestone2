package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class RedirectLinkPage {

    private static final Logger log = LogManager.getLogger(RedirectLinkPage.class);
    private WebDriver driver;

    public RedirectLinkPage(WebDriver driver) {
        try{
        Reporter.log("Initializing RedirectLinkPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(id = "redirect")
    private WebElement redirectLink;

    public void clickRedirectLink() {
        try{
        Reporter.log("Clicking redirect link", true);
        WaitUtil.waitForClick(driver, redirectLink);
        redirectLink.click();
        log.info("Redirect link clicked");
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
