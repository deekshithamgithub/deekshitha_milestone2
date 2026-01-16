//package herokuapp.pagestest;
//
//import herokuapp.basetest.BaseTest;
//import herokuapp.pages.*;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.time.Duration;
//
//public class HerokuAppCrossBrowserTest extends BaseTest {
//
//    // 1
//    @Test
//    public void tc01_verifyTitle() {
//        Assert.assertTrue(driver.getTitle().contains("The Internet"));
//    }
//
//    // 2
//    @Test
//    public void tc02_verifyHeaderText() {
//        HomePage home = new HomePage(driver);
//        Assert.assertEquals(home.getHeaderText(), "Welcome to the-internet");
//    }
//
//    // 3
//    @Test
//    public void tc03_verifySubHeaderText() {
//        HomePage home = new HomePage(driver);
//        Assert.assertTrue(home.getSubHeaderText().contains("Available Examples"));
//    }
//
//    // 4
//    @Test
//    public void tc04_openABTestingAndVerifyHeading() {
//        HomePage home = new HomePage(driver);
//        home.openLink("A/B Testing");
//        Assert.assertTrue(driver.getPageSource().contains("A/B Test"));
//    }
//
//    // 5
//    @Test
//    public void tc05_refreshABTesting() {
//        HomePage home = new HomePage(driver);
//        home.openLink("A/B Testing");
//        driver.navigate().refresh();
//        Assert.assertTrue(driver.getPageSource().length() > 0);
//    }
//
//    // 6
//    @Test
//    public void tc06_openAddRemoveElements() {
//        HomePage home = new HomePage(driver);
//        home.openLink("Add/Remove Elements");
//        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
//        Assert.assertEquals(page.getHeading(), "Add/Remove Elements");
//    }
//
//    // 7
//    @Test
//    public void tc07_addElementShowsDeleteButton() {
//        HomePage home = new HomePage(driver);
//        home.openLink("Add/Remove Elements");
//        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
//        page.clickAddElement();
//        Assert.assertEquals(page.getDeleteButtonsCount(), 1);
//    }
//
//    // 8
//    @Test
//    public void tc08_deleteButtonRemovesElement() {
//        HomePage home = new HomePage(driver);
//        home.openLink("Add/Remove Elements");
//        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
//        page.clickAddElement();
//        page.clickFirstDelete();
//        Assert.assertEquals(page.getDeleteButtonsCount(), 0);
//    }
//
//    // 9
//    @Test
//    public void tc09_addThreeElements() {
//        HomePage home = new HomePage(driver);
//        home.openLink("Add/Remove Elements");
//        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
//        page.clickAddElement();
//        page.clickAddElement();
//        page.clickAddElement();
//        Assert.assertEquals(page.getDeleteButtonsCount(), 3);
//    }
//
//    // 10
//    @Test
//    public void tc10_openCheckboxesVerifyCount() {
//        HomePage home = new HomePage(driver);
//        home.openLink("Checkboxes");
//        CheckboxesPage cb = new CheckboxesPage(driver);
//        Assert.assertEquals(cb.countCheckboxes(), 2);
//    }
//
//    // 11
//    @Test
//    public void tc11_selectCheckbox1() {
//        HomePage home = new HomePage(driver);
//        home.openLink("Checkboxes");
//        CheckboxesPage cb = new CheckboxesPage(driver);
//
//        if (!cb.isChecked(0)) cb.clickCheckbox(0);
//        Assert.assertTrue(cb.isChecked(0));
//    }
//
//    // 12
//    @Test
//    public void tc12_unselectCheckbox2() {
//        HomePage home = new HomePage(driver);
//        home.openLink("Checkboxes");
//        CheckboxesPage cb = new CheckboxesPage(driver);
//
//        if (cb.isChecked(1)) cb.clickCheckbox(1);
//        Assert.assertFalse(cb.isChecked(1));
//    }
//
//    // 13
//    @Test
//    public void tc13_dropdownSelectOption1() {
//        HomePage home = new HomePage(driver);
//        home.openLink("Dropdown");
//        DropdownPage dp = new DropdownPage(driver);
//        dp.selectByVisibleText("Option 1");
//        Assert.assertEquals(dp.getSelectedOption(), "Option 1");
//    }
//
//    // 14
//    @Test
//    public void tc14_dropdownSelectOption2() {
//        HomePage home = new HomePage(driver);
//        home.openLink("Dropdown");
//        DropdownPage dp = new DropdownPage(driver);
//        dp.selectByVisibleText("Option 2");
//        Assert.assertEquals(dp.getSelectedOption(), "Option 2");
//    }
//
//    // 15
//    @Test
//    public void tc15_dynamicControlsRemoveCheckbox() {
//        HomePage home = new HomePage(driver);
//        home.openLink("Dynamic Controls");
//        DynamicControlsPage dc = new DynamicControlsPage(driver);
//
//        dc.clickRemove();
//        dc.waitUntilCheckboxGone();
//        Assert.assertEquals(dc.waitForMessage(), "It's gone!");
//    }
//
//    // 16
//    @Test
//    public void tc16_dynamicControlsAddCheckboxBack() {
//        HomePage home = new HomePage(driver);
//        home.openLink("Dynamic Controls");
//        DynamicControlsPage dc = new DynamicControlsPage(driver);
//
//        if (dc.isCheckboxPresent()) {
//            dc.clickRemove();
//            dc.waitUntilCheckboxGone();
//            dc.waitForMessage();
//        }
//
//        dc.clickAdd();
//        dc.waitUntilCheckboxBack();
//        Assert.assertEquals(dc.waitForMessage(), "It's back!");
//    }
//
//    // 17
//    @Test
//    public void tc17_jsAlertAccept() {
//        HomePage home = new HomePage(driver);
//        home.openLink("JavaScript Alerts");
//        AlertsPage ap = new AlertsPage(driver);
//
//        ap.clickJSAlert();
//        driver.switchTo().alert().accept();
//        Assert.assertTrue(ap.getResultText().contains("You successfully clicked an alert"));
//    }
//
//    // 18
//    @Test
//    public void tc18_jsConfirmDismiss() {
//        HomePage home = new HomePage(driver);
//        home.openLink("JavaScript Alerts");
//        AlertsPage ap = new AlertsPage(driver);
//
//        ap.clickJSConfirm();
//        driver.switchTo().alert().dismiss();
//        Assert.assertTrue(ap.getResultText().contains("You clicked: Cancel"));
//    }
//
//    // 19
//    @Test
//    public void tc19_iFrameTypeText() {
//
////        HomePage home = new HomePage(driver);
////        home.openLink("Frames");
////        home.openLink("iFrame");
////
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////
////        // ✅ Switch to iframe
////        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));
////
////        WebElement editor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
////
////        // ✅ Click editor first (important!)
////        Actions actions = new Actions(driver);
////        actions.moveToElement(editor).click().perform();
////
////        // ✅ Select all + delete properly
////        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
////        actions.sendKeys(Keys.BACK_SPACE).perform();
////
////        // ✅ Type new text
////        actions.sendKeys("Hello Herokuapp Frame").perform();
////
////        // ✅ Verify
////        String actualText = editor.getText().trim();
////
////        driver.switchTo().defaultContent();
////
////        Assert.assertEquals(actualText, "Hello Herokuapp Frame");
//
//        HomePage home = new HomePage(driver);
//        home.openLink("Frames");
//        home.openLink("iFrame");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // ✅ Switch to iframe
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));
//
//        WebElement editor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
//
//        // ✅ Alternative Method: JavaScript set text
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].innerHTML='';", editor);
//        js.executeScript("arguments[0].innerHTML='Hello Herokuapp Frame';", editor);
//
//        String actualText = editor.getText().trim();
//        driver.switchTo().defaultContent();
//
//        Assert.assertEquals(actualText, "Hello Herokuapp Frame");
//
//    }
//
//    // 20
//    @Test
//    public void tc20_fileUpload() throws Exception {
//        HomePage home = new HomePage(driver);
//        home.openLink("File Upload");
//
//        // create temp file to upload
//        File f = new File(System.getProperty("user.dir") + "/upload_sample.txt");
//        try (FileWriter fw = new FileWriter(f)) {
//            fw.write("Upload test file");
//        }
//
//        FileUploadPage up = new FileUploadPage(driver);
//        up.uploadFile(f.getAbsolutePath());
//
//        Assert.assertEquals(up.getUploadedHeading(), "File Uploaded!");
//    }
//}
