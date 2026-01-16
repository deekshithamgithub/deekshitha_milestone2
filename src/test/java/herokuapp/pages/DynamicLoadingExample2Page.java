package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DynamicLoadingExample2Page {

    private static final Logger log = LogManager.getLogger(DynamicLoadingExample2Page.class);
    private WebDriver driver;

    public DynamicLoadingExample2Page(WebDriver driver) {
        Reporter.log("Initializing DynamicLoadingExample2Page", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#start button")
    private WebElement startBtn;

    @FindBy(id = "finish")
    private WebElement finishText;

    public void clickStart() {
        Reporter.log("Clicking Start button", true);
        WaitUtil.waitForClick(driver, startBtn);
        startBtn.click();
        log.info("Start clicked");
    }

    public String getFinishText() {
        Reporter.log("Fetching finish text", true);
        WaitUtil.waitForVisibility(driver, finishText);
        return finishText.getText();
    }
}
