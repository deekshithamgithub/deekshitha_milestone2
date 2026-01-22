package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class InputsPage {

    private static final Logger log = LogManager.getLogger(InputsPage.class);
    private WebDriver driver;

    public InputsPage(WebDriver driver) {
        try{
        Reporter.log("Initializing InputsPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(tagName = "input")
    private WebElement input;

    public void enterNumber(String value) {
        try{
        Reporter.log("Entering number: " + value, true);
        WaitUtil.waitForVisibility(driver, input);
        input.clear();
        input.sendKeys(value);
        log.info("Entered value: " + value);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValue() {
        try{
        return input.getAttribute("value");
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
