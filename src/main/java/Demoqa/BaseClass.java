package Demoqa;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // 1. Launch Chrome Browser
    public void launchBrowser() {

        System.setProperty(
            "webdriver.chrome.driver",
            "C:\\selenium\\Corefiles1\\chromedriver.exe"
        );

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demo-qa-app.azurewebsites.net/");

        String title = driver.getCurrentUrl();

        assertEquals(title, "https://demo-qa-app.azurewebsites.net/");
    }

    // 2. Capture Screenshot on Test Failure
    public void captureScreenshot(String testName) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            File destination = new File(
                System.getProperty("user.dir")
                + "/screenshots/" + testName + ".png"
            );

            destination.getParentFile().mkdirs();

            Files.copy(
                source.toPath(),
                destination.toPath(),
                StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                "Screenshot saved: " + destination.getAbsolutePath()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. Get WebDriver instance
    public WebDriver getDriver() {
        return driver;
    }

    // 4. Close Browser
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}