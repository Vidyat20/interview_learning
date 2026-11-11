
package Demoqa;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;


@BeforeMethod(alwaysRun = true)
public void launchBrowser() {

    System.out.println("Browser initialization started");

    System.setProperty(
        "webdriver.chrome.driver",
        "C:\\selenium\\Corefiles1\\chromedriver.exe"
    );

    driver = new ChromeDriver();

    driver.manage().window().maximize();

    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.get("https://demo-qa-app.azurewebsites.net/");

    System.out.println("Driver initialized: " + (driver != null));
    System.out.println("Wait initialized: " + (wait != null));
}


    public void captureScreenshot(String testName) {

        try {
            if (driver == null) return;

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }
}
