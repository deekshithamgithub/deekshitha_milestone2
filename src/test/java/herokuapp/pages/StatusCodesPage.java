package herokuapp.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class StatusCodesPage {

    private static final Logger log = LogManager.getLogger(StatusCodesPage.class);
    private WebDriver driver;

    public StatusCodesPage(WebDriver driver) {
        Reporter.log("Initializing StatusCodesPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "404")
    private WebElement code404;

    public void open404() {
        Reporter.log("Opening 404 status code page", true);
        code404.click();
        log.info("404 opened");
    }
}
