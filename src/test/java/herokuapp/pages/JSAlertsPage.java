package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class JSAlertsPage {

    private static final Logger log = LogManager.getLogger(JSAlertsPage.class);
    private WebDriver driver;

    public JSAlertsPage(WebDriver driver) {
        Reporter.log("Initializing JSAlertsPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement jsAlertBtn;

    @FindBy(id = "result")
    private WebElement result;

    public void clickJSAlert() {
        Reporter.log("Clicking JS Alert button", true);
        WaitUtil.waitForClick(driver, jsAlertBtn);
        jsAlertBtn.click();
        log.info("JS Alert clicked");
    }

    public String getResult() {
        Reporter.log("Fetching JS Alert result", true);
        WaitUtil.waitForVisibility(driver, result);
        return result.getText();
    }
}
