//package herokuapp.utility;
//
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import orangehrm.configreader.ConfigReader;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Reporter;
//import org.testng.log4testng.Logger;
//
//public class DriverFactory {
//    private static final Logger log= Logger.getLogger(orangehrm.driverfactory.DriverFactory.class);
//    // Thread safe driver (parallel execution ke liye)
//    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//    public static void initDriver() throws InterruptedException {
//        String browser="chrome";
//        Reporter.log("login test started",true);
//        Reporter.log(browser,true);
//        if (browser == null) {
//            browser = "chrome";
//        }
//        switch (browser.toLowerCase()) {
//            case "chrome":
//                WebDriverManager.chromedriver().setup();
//                driver.set(new ChromeDriver());
//                break;
//
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                driver.set(new FirefoxDriver());
//                break;
//
//            case "edge":
////                WebDriverManager.edgedriver().setup();
////                System.setProperty("webdriver.edge.driver",
////                        System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
////                EdgeOptions options = new EdgeOptions();
////                options.addArguments("--guest");
////                options.addArguments("--remote-allow-origins=*");
////                options.addArguments("--disable-extensions");
////                options.addArguments("--disable-popup-blocking");
////                options.addArguments("--inprivate");
////                options.addArguments("--remote-allow-origins=*");
////               options.addArguments("start-maximized");
////                driver.set(new EdgeDriver(options));
////                break;
//                String edgeDriverPath = System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe";
//                System.setProperty("webdriver.edge.driver", edgeDriverPath);
//
//                EdgeOptions options = new EdgeOptions();
//                options.addArguments("--guest");
//                options.addArguments("--inprivate");
//                options.addArguments("--disable-extensions");
//                options.addArguments("--remote-allow-origins=*");
//
//                driver.set(new EdgeDriver(options));
//                Thread.sleep(2000);   // ✅ Edge stability wait
//                break;
//            default:
//                throw new RuntimeException("Invalid browser: " + browser);
//        }
//
//        getDriver().manage().window().maximize();
//        getDriver().manage().timeouts()
//                .implicitlyWait(
//                        Duration.ofSeconds(
//                                Integer.parseInt(
//                                        ConfigReader.get("implicit.wait")
//                                )
//                        )
//                );
//
//    }
//
//    public static WebDriver getDriver() {
//        log.info("Taking driver object");
//        return driver.get();
//    }
//
//    public static void quitDriver() {
//        try {
//            if (driver.get() != null) {
//                driver.get().quit();
//                driver.remove();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
////        try {
////            Runtime.getRuntime().exec("taskkill /F /IM msedge.exe");
////            Runtime.getRuntime().exec("taskkill /F /IM msedgedriver.exe");
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//    }
//
//}


package herokuapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {

        WebDriver localDriver;

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                localDriver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                localDriver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                // If your PC has internet restrictions for msedgedriver,
                // comment WebDriverManager and use local msedgedriver.exe (as you did before).
                // WebDriverManager.edgedriver().setup();

                // ✅ Recommended (local driver support):
                // System.setProperty("webdriver.edge.driver",
                //         System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");

//                WebDriverManager.edgedriver().setup();
//                EdgeOptions edgeOptions = new EdgeOptions();
//                edgeOptions.addArguments("--guest");
//                edgeOptions.addArguments("--inprivate");
//                edgeOptions.addArguments("--remote-allow-origins=*");
//                localDriver = new EdgeDriver(edgeOptions);
//                break;

                System.setProperty("webdriver.edge.driver",
                        System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");

                EdgeOptions options = new EdgeOptions();
                options.addArguments("--guest");
                options.addArguments("--inprivate");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-extensions");

                localDriver = new EdgeDriver(options);
                break;


            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        localDriver.manage().window().maximize();
        driver.set(localDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        try {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

