//package herokuapp.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class FileUploadPage {
//
//    private final WebDriver driver;
//
//    private final By chooseFile = By.id("file-upload");
//    private final By uploadBtn = By.id("file-submit");
//    private final By uploadedText = By.tagName("h3");
//
//    public FileUploadPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public void uploadFile(String absolutePath) {
//        driver.findElement(chooseFile).sendKeys(absolutePath);
//        driver.findElement(uploadBtn).click();
//    }
//
//    public String getUploadedHeading() {
//        return driver.findElement(uploadedText).getText();
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

public class FileUploadPage {

    private static final Logger log = LogManager.getLogger(FileUploadPage.class);
    private WebDriver driver;

    public FileUploadPage(WebDriver driver) {
        try{
        Reporter.log("Initializing FileUploadPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(id = "file-upload")
    private WebElement chooseFile;

    @FindBy(id = "file-submit")
    private WebElement uploadBtn;

    @FindBy(tagName = "h3")
    private WebElement uploadedHeading;

    public void uploadFile(String absolutePath) {
        try{
        Reporter.log("Uploading file: " + absolutePath, true);
        chooseFile.sendKeys(absolutePath);
        WaitUtil.waitForClick(driver, uploadBtn);
        uploadBtn.click();
        log.info("Upload clicked");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUploadedHeading() {
        try{
        WaitUtil.waitForVisibility(driver, uploadedHeading);
        return uploadedHeading.getText();
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

