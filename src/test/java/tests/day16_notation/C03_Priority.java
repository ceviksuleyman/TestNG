package tests.day16_notation;

import org.testng.annotations.Test;
import utilities.TBBeforeMethodAfterMethod;

public class C03_Priority extends TBBeforeMethodAfterMethod {

    /*
    Testlerimizi calistirirken istedigimiz siraya gore calismasini istersek priority method'unu kullaniriz.
    Priority kullanmazsak default olarak '0' dir.
     */
    @Test(priority = 1)
    public void youtubeTest() {

        driver.get("https://www.youtube.com");
    }

    @Test(priority = 3)
    public void amazonTest() {

        driver.get("https://www.amazon.com");
    }

    @Test // Burayi 0(sifir) kabul eder, o yuzden ilk burasi calisir.
    public void bestBuyTest() {

        driver.get("https://www.bestbuy.com");
    }

    @Test(priority = -1)
    public void hepsiBuradaTest() {

        driver.get("https://www.hepsiburada.com");
    }
}
