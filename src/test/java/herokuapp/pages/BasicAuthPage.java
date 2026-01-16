package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BasicAuthPage {

    private static final Logger log = LogManager.getLogger(BasicAuthPage.class);
    private WebDriver driver;

    public BasicAuthPage(WebDriver driver) {
        Reporter.log("Initializing BasicAuthPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "p")
    private WebElement message;

    public String getMessageText() {
        Reporter.log("Fetching BasicAuth success message", true);
        WaitUtil.waitForVisibility(driver, message);
        String text = message.getText();
        log.info("Auth Message: " + text);
        return text;
    }
}
