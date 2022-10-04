package tests.day21_reusableMethods;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenshotReusableMethod {

    @Test
    public void test01() throws IOException, IOException {
        //Hepsiburada sayfasina git
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        //sayfanin ekran goruntusunu al
        ReusableMethods.getScreenshot("HepsiBurda");

        //Driver.closeDriver();
    }

    @Test
    public void test02() throws IOException {
        AmazonPage page = new AmazonPage();

        //amazon sayfasina git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //nutella ara
        page.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //arama sonuc yazisi webelementinin ekran goruntusunu al
        ReusableMethods.getScreenshotWebElement("nutellaAramaSonucu",page.aramaSonucuWE);
    }
}
