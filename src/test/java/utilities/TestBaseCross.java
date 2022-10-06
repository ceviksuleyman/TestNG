package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBaseCross {

    protected WebDriver driver;

    @Parameters("browser") //parameters ve optional beraber kullanilir.
    @BeforeClass // BeforeMethod da olur
    public void setUp(@Optional String browser) {

        driver = CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {

        CrossDriver.closeDriver();
    }
}
