package tests.day16_notation;

import org.testng.annotations.Test;
import utilities.TBBeforeMethodAfterMethod;

public class C01_BeforeMethodAfterMethod extends TBBeforeMethodAfterMethod {

    @Test
    public void amazonTest() {

        driver.get("https://www.amazon.com");
    }

    @Test
    public void bestbuyTest() {

        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techproeducationTest() {

        driver.get("https://www.techproeducation.com");
    }
}
