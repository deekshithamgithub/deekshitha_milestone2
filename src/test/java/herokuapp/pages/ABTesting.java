//package herokuapp.pages;
//
//import orangehrm.pages.LoginPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Reporter;
//import org.testng.log4testng.Logger;
//
//public class ABTesting {
//    private static final Logger log =
//            Logger.getLogger(LoginPage.class);
//
//    private WebDriver driver;
//
//    public ABTesting(WebDriver driver) {
//        Reporter.log("LoginPage contructor start to initialise Driver",true);
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//}

package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ABTesting {

    private static final Logger log = LogManager.getLogger(ABTesting.class);
    private WebDriver driver;

    public ABTesting(WebDriver driver) {
        try {
            Reporter.log("Initializing ABTestingPage", true);
            this.driver = driver;
            PageFactory.initElements(driver, this);
            log.info("ABTestingPage initialized");
        } catch (Exception e) {
            Reporter.log(" Error while initializing ABTestingPage: " + e.getMessage(), true);
            log.error("Error while initializing ABTestingPage", e);
        }
    }

    @FindBy(tagName = "h3")
    private WebElement heading;

    @FindBy(tagName = "p")
    private WebElement paragraph;

    public String getHeadingText() {
        try {
            Reporter.log("Getting AB Testing heading text", true);
            WaitUtil.waitForVisibility(driver, heading);

            String text = heading.getText();
            log.info("Heading: " + text);
            return text;

        } catch (Exception e) {
            Reporter.log(" Error while getting heading text: " + e.getMessage(), true);
            log.error("Error while getting heading text", e);
            return null;   // returning null if fails
        }
    }
    public boolean isParagraphDisplayed() {
        try {
            Reporter.log("Checking AB Testing paragraph displayed", true);
            WaitUtil.waitForVisibility(driver, paragraph);

            boolean status = paragraph.isDisplayed();
            log.info("Paragraph displayed: " + status);
            return status;

        } catch (Exception e) {
            Reporter.log(" Error while checking paragraph display: " + e.getMessage(), true);
            log.error("Error while checking paragraph display", e);
            return false;  // returning false if fails
        }
    }
}
