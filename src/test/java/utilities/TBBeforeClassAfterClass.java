package utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TBBeforeClassAfterClass {

    protected WebDriver driver;
    protected Actions actions;
    protected String tarih1;
    protected String tarih2;

    protected Faker faker;

    protected Select select;

    protected SoftAssert softAssert;

    protected DateTimeFormatter formater1, formatter2;

    /*
    @BeforeClass ve @AfterClass notasyonlarini TestNG de kullanirken JUnit'deki gibi static yapmaya gerek YOKTUR.
     */
    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);
        faker = new Faker();
        softAssert = new SoftAssert();

        LocalDateTime date = LocalDateTime.now();
        formater1 = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
        tarih1 = date.format(formater1);
        tarih2 = date.format(formatter2);
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
