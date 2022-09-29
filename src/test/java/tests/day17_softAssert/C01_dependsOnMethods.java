package tests.day17_softAssert;

import org.testng.annotations.Test;
import utilities.TBBeforeMethodAfterMethod;

public class C01_dependsOnMethods extends TBBeforeMethodAfterMethod {

    @Test // default 0 ikinci calisir
    public void test01() {
        driver.get("https://www.wamazon11.com");
    }

    @Test(dependsOnMethods = "test01")  // test01 ' e bagli oldugu icin test01 calismadan buraya gecmez
    public void test02() {
        driver.get("https://www.facebook.com");
    }

    @Test(dependsOnMethods = "test02") // test02 ' e bagli oldugu icin test02 calismadan buraya gecmez
    public void test03() {
        driver.get("https://www.bestbuy.com");
    }

    @Test(priority = -1) // ilk calisir
    public void test04() {
        driver.get("https://www.youtube.com");
    }

}
