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
        try {
        driver.findElement(jsAlertBtn).click();
        }catch (Exception e) {
            e.printStackTrace();
        }
            
    }

    public void clickJSConfirm() {
        try {
        driver.findElement(jsConfirmBtn).click();
        }catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public void clickJSPrompt() {
         try {
       driver.findElement(jsPromptBtn).click();
        }catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public String getResultText() {
         try {
       return driver.findElement(result).getText();
        }catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
