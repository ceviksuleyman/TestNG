package tests.day20_smoke_E2ETest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Rm;

public class C01_SmokePositiveTest {

    /*
     https://www.hotelmycamp.com adresine git
     login butonuna bas
     test data username: manager ,
     test data password : Manager1!
     Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void validUsernamePassword() {

        Driver.getDriver().get(ConfigReader.getProperty("hotelMyUrl"));

        HmcPage hmcPage = new HmcPage();

        hmcPage.loginButton.click();

        Rm.getActions()
                .click(hmcPage.username)
                .sendKeys(ConfigReader.getProperty("hmcUsname"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hmcpassw"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hmcPage.girisBasarili.isDisplayed());

        Driver.closeDriver();
    }
}
