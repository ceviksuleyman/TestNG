package tests.day22_reports_crossBrowser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {

    BrcPage brcPage;
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() {

        // Test raporlama objesi
        extentTest = extentReports.createTest(
                "Pozitif Test",
                "Gecerli kullanici email ve sifre ile giris yapildi");
        /*
       -https://www.bluerentalcars.com/ adresine git
       -login butonuna bas
       -test data user email: customer@bluerentalcars.com ,
       -test data password : 12345 dataları girip login e basın
       -login butonuna tiklayin
       -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        */
        Driver.getDriver().get(ConfigReader.getProperty("bRCUrl"));
        extentTest.info("Blue Rant a Car sitesine gidildi");

        brcPage = new BrcPage();

        brcPage.loginButton.click();
        extentTest.info("Login buttonuna basildi");


        actions.click(brcPage.emailBox).
                sendKeys(ConfigReader.getProperty("bRCEmail")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("bRCPassword")).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();
        extentTest.info("Dogru Kullanici email ve sifre girildi.");

        extentTest.info("Ikinci Login butonuna basildi");


        String expectedUser = "John Walker";
        String actualUser = brcPage.loggedInAs.getText();
        Assert.assertEquals(actualUser, expectedUser);
        extentTest.info("Kullanici basariyla giris yapti");


        extentTest.pass("Test Bitti");
    }
}