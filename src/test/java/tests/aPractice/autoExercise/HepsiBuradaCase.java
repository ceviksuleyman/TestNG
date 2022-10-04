package tests.aPractice.autoExercise;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class HepsiBuradaCase {

    HepsiBuradaPage page;

    Actions actions;

    @Test
    public void hepsiburda() throws IOException, IOException {

        // Hepsiburada sayfasına gidiniz
        // Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
        // Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
        // Sayfayı kapatalım

        page = new HepsiBuradaPage();

        actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        ilk2Tik();

        int count = 1;
        for (int i = 0; i < page.kucukAltBaslikar.size(); i++) {


            page.kucukAltBaslikar.get(i).click();

            // actions.sendKeys(Keys.PAGE_DOWN).perform();   // sayfayi kaydir

            ReusableMethods.getScreenshot("SS" + count);
            ReusableMethods.waitFor(1);
            count++;


            Driver.getDriver().navigate().back(); //sayfa geri
            ReusableMethods.waitFor(2);


            ilk2Tik(); // method
            ReusableMethods.waitFor(1);
        }
    }


    public void ilk2Tik() { //method

        actions.moveToElement(page.elektronics).perform();
        ReusableMethods.waitFor(1);

        actions.moveToElement(page.bilgisayarTablet).perform();
        ReusableMethods.waitFor(1);
    }
}
