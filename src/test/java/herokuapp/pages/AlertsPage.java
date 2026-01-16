package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private final WebDriver driver;

    private final By jsAlertBtn = By.xpath("//button[text()='Click for JS Alert']");
    private final By jsConfirmBtn = By.xpath("//button[text()='Click for JS Confirm']");
    private final By jsPromptBtn = By.xpath("//button[text()='Click for JS Prompt']");
    private final By result = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickJSAlert() {
        driver.findElement(jsAlertBtn).click();
    }

    public void clickJSConfirm() {
        driver.findElement(jsConfirmBtn).click();
    }

    public void clickJSPrompt() {
        driver.findElement(jsPromptBtn).click();
    }

    public String getResultText() {
        return driver.findElement(result).getText();
    }
}
