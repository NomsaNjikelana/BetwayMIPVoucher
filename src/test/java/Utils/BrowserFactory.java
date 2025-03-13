package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BrowserFactory {

    static WebDriver driver;

    @BeforeTest
    public static WebDriver startBrowser(String browserChoice, String url) {

        if (browserChoice.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }


        driver.manage().window().maximize();
        driver.get(url);
        return driver;

    }
}
