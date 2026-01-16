package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MultipleWindowsPage {

    private static final Logger log = LogManager.getLogger(MultipleWindowsPage.class);
    private WebDriver driver;

    public MultipleWindowsPage(WebDriver driver) {
        Reporter.log("Initializing MultipleWindowsPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Click Here")
    private WebElement clickHere;

    public void openNewWindow() {
        Reporter.log("Clicking to open new window", true);
        WaitUtil.waitForClick(driver, clickHere);
        clickHere.click();
        log.info("New window opened");
    }
}
