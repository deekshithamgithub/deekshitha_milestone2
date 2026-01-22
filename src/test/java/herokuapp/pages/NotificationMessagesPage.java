
package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NotificationMessagesPage {

    private static final Logger log = LogManager.getLogger(NotificationMessagesPage.class);
    private WebDriver driver;

    public NotificationMessagesPage(WebDriver driver) {
        try{
        Reporter.log("Initializing NotificationMessagesPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(linkText = "Click here")
    private WebElement clickHere;

    @FindBy(id = "flash")
    private WebElement flashMsg;

    public void clickNotification() {
        try{
        Reporter.log("Clicking notification", true);
        WaitUtil.waitForClick(driver, clickHere);
        clickHere.click();
        log.info("Notification clicked");
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMessage() {
        try{
        WaitUtil.waitForVisibility(driver, flashMsg);
        return flashMsg.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
