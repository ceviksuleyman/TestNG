package tests.day23_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {

    AmazonPage page ;


    @Test
    public void test01() {

        page = new AmazonPage();
        // amazon anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // "Nutella" ara
        page.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // arama sonucunun Nutella icerdigini test et
        Assert.assertTrue(page.aramaSonucu.getText().contains("Nutella"));

        // kapat
        Driver.closeDriver();
    }


    /*
    Arayacagimiz kelimeleri bir liste gibi tutup yollayacak bir veri saglayicisi olusturacagiz
     */
    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object[][] arananKelimeArr = {{"Nutella"}, {"Java"}, {"Cigdem"}, {"Netherlands"}};
        return arananKelimeArr;
    }

    @Test(dataProvider = "AranacakKelimeler")
    public void dataProviderTest(String arananKelime) {

        page = new AmazonPage();

        // amazon anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));


        // Nutella, Java, Cigdem, Netherlands icin arama yap
        page.aramaKutusu.sendKeys(arananKelime, Keys.ENTER);


        // Sonuclarin aradigimiz kelimeyi icerdigini test et
        Assert.assertTrue(page.aramaSonucu.getText().contains(arananKelime));


        //kapat
        Driver.closeDriver();

    }
}
