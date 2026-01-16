package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ForgotPasswordPage {

    private static final Logger log = LogManager.getLogger(ForgotPasswordPage.class);
    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        Reporter.log("Initializing ForgotPasswordPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "form_submit")
    private WebElement retrieveBtn;

    public void enterEmail(String mail) {
        Reporter.log("Entering email: " + mail, true);
        WaitUtil.waitForVisibility(driver, email);
        email.clear();
        email.sendKeys(mail);
        log.info("Email entered");
    }

    public void clickRetrievePassword() {
        Reporter.log("Clicking retrieve password button", true);
        WaitUtil.waitForClick(driver, retrieveBtn);
        retrieveBtn.click();
        log.info("Retrieve clicked");
    }
}
