package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TBBeforeMethodAfterMethod {

    protected WebDriver driver;
    protected Actions actions;
    protected String tarih1;
    protected String tarih2;

    protected SoftAssert softAssert;

    protected DateTimeFormatter formater1, formatter2;

    // TestNG'de framework'unde @Before @After notasyonlari yerine @BeforeMethod @AfterMethod kullanilir.
    // Calisma prensipleri JUnit'deki Before,After ile aynidir.
    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);
        softAssert = new SoftAssert();

        LocalDateTime date = LocalDateTime.now();
        formater1 = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
        tarih1 = date.format(formater1);
        tarih2 = date.format(formatter2);
    }

    @AfterMethod
    public void tearDown() {

        //driver.quit();
    }
}
