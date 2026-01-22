package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    private final WebDriver driver;
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectByVisibleText(String text) {
        try{
        new Select(driver.findElement(dropdown)).selectByVisibleText(text);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSelectedOption() {
         try{
        return new Select(driver.findElement(dropdown)).getFirstSelectedOption().getText();
             } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
