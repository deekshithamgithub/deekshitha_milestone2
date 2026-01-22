package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FormAuthPage {

    private static final Logger log = LogManager.getLogger(FormAuthPage.class);
    private WebDriver driver;

    public FormAuthPage(WebDriver driver) {
        try{
        Reporter.log("Initializing FormAuthPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    @FindBy(id = "flash")
    private WebElement flash;

    public void login(String user, String pass) {
        try{
        Reporter.log("Logging in user: " + user, true);
        WaitUtil.waitForVisibility(driver, username);
        username.clear();
        username.sendKeys(user);

        password.clear();
        password.sendKeys(pass);

        WaitUtil.waitForClick(driver, loginBtn);
        loginBtn.click();
        log.info("Login submitted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFlashMessage() {
        try{
        WaitUtil.waitForVisibility(driver, flash);
        return flash.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
