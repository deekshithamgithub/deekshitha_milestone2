//package herokuapp.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//import java.time.Duration;
//
//public class DynamicControlsPage {
//
//    private final WebDriver driver;
//    private final WebDriverWait wait;
//
//    private final By removeBtn = By.xpath("//button[contains(text(),'Remove')]");
//    private final By addBtn = By.xpath("//button[contains(text(),'Add')]");
//    private final By checkbox = By.id("checkbox");
//    private final By message = By.id("message");
//
//    public DynamicControlsPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    public void clickRemove() {
//        driver.findElement(removeBtn).click();
//    }
//
//    public void clickAdd() {
//        driver.findElement(addBtn).click();
//    }
//
//    public String waitForMessage() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
//    }
//
//    public boolean isCheckboxPresent() {
//        return driver.findElements(checkbox).size() > 0;
//    }
//
//    public void waitUntilCheckboxGone() {
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
//    }
//
//    public void waitUntilCheckboxBack() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
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

public class DynamicControlsPage {

    private static final Logger log = LogManager.getLogger(DynamicControlsPage.class);
    private WebDriver driver;

    public DynamicControlsPage(WebDriver driver) {
        try{
        Reporter.log("Initializing DynamicControlsPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    private WebElement removeBtn;

    @FindBy(id = "message")
    private WebElement message;

    public void clickRemove() {
          try{
        Reporter.log("Clicking Remove button", true);
        WaitUtil.waitForClick(driver, removeBtn);
        removeBtn.click();
        log.info("Remove clicked");
              } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMessage() {
          try{
        Reporter.log("Fetching dynamic controls message", true);
        WaitUtil.waitForVisibility(driver, message);
        return message.getText();
              } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
