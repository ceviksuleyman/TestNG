package utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Driver {

    private Driver() {  // singletonPattern
    }

    static WebDriver driver;
    public static WebDriver getDriver() {  // Webdriver getDriver method
        if (driver == null) {

            switch (ConfigReader.getProperty("browser")){
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                //case "headless-chrome": //chrome acmadan test ! kullanilmaz
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }//switch
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }// if
        return driver;
    } //method son

    public static void closeDriver() { //close Method

        if (driver != null) {
            driver.close();
            driver = null;
        }
    }//method son

    public static void quitDriver() { //quit Method
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }//method son
}//class
