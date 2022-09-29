package tests.day16_notation;

import org.testng.annotations.Test;
import utilities.TBBeforeClassAfterClass;

public class C02_BeforeClassAfterClass extends TBBeforeClassAfterClass {

    @Test
    public void testAmazon() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void testBestbuy() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void testTechpro() {
        driver.get("https://www.techproeducation.com");
    }
}
