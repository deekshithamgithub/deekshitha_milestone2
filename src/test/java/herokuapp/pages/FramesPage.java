package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FramesPage {

    private static final Logger log = LogManager.getLogger(FramesPage.class);
    private WebDriver driver;

    public FramesPage(WebDriver driver) {
        Reporter.log("Initializing FramesPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;

    @FindBy(id = "tinymce")
    private WebElement editor;

    public void setTextUsingJS(String text) {
        Reporter.log("Typing text using JS in iframe", true);

        driver.switchTo().frame(iframe);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerHTML='';", editor);
        js.executeScript("arguments[0].innerHTML=arguments[1];", editor, text);

        log.info("Typed in iframe: " + text);

        driver.switchTo().defaultContent();
    }

    public String getEditorText() {
        driver.switchTo().frame(iframe);
        String value = editor.getText().trim();
        driver.switchTo().defaultContent();
        return value;
    }
}
