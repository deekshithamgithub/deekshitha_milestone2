package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckboxesPage {

    private final WebDriver driver;
    private final By checkboxes = By.cssSelector("input[type='checkbox']");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public int countCheckboxes() {
        try{
        return driver.findElements(checkboxes).size();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isChecked(int index) {
         try{
        List<WebElement> list = driver.findElements(checkboxes);
        return list.get(index).isSelected();
         }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickCheckbox(int index) {
         try{
        driver.findElements(checkboxes).get(index).click();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
