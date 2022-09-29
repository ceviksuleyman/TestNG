package tests.day17_softAssert;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverIlkTest {

    /*
    TestBase class'ina extend ederek kullandigimiz driver yerine artik Driver class'indan kullanacagimiz
    getDriver() static method'unu kullaniriz.
     */
    @Test
    public void test01() {

        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://www.hepsiburada.com");
        Driver.closeDriver();
    }
}
