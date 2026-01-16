package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HorizontalSliderPage {

    private static final Logger log = LogManager.getLogger(HorizontalSliderPage.class);
    private WebDriver driver;

    public HorizontalSliderPage(WebDriver driver) {
        Reporter.log("Initializing HorizontalSliderPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "input")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement range;

    public void moveSliderRight(int steps) {
        Reporter.log("Moving slider to right steps: " + steps, true);
        WaitUtil.waitForVisibility(driver, slider);
        for (int i = 0; i < steps; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        log.info("Slider moved");
    }

    public String getSliderValue() {
        WaitUtil.waitForVisibility(driver, range);
        return range.getText();
    }
}
