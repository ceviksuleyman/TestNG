package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossDriver {

    static WebDriver driver;

    private CrossDriver() { // singletonPattern
    }

    /*
    Testlerimizi xml file'dan farkli browser'lar ile calistirabilmek icin
    getDriver method'una parametre atamamiz gereklidir.
     */
    public static WebDriver getDriver(String browser) {  // Webdriver getDriver method

        // Olur da browser null gelirse browser bos gecmesin diye emniyet !
        browser = (browser == null)? ConfigReader.getProperty("browser") : browser;

        if (driver == null) {

            switch (browser) {
                /*
                crossBrowser icin bizim gonderdigimiz browser uzerinden calismasi icin
                buraya parametre olarak girdigimiz degeri yazdik.
                 */

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    // headless-chrome
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));

            }//switch

        }//if

        return driver;
    } //method son

    public static void closeDriver() { //close Method

        if (driver != null) {
            driver.close();
            driver = null;
        }
    }//method son
}
