package tests.day19_PositiveNegativeTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class C02_PositiveTest {

     /*
     https://www.hotelmycamp.com adresine git
     login butonuna bas
     test data username: manager ,
     test data password : Manager1!
     Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void positiveTest() {

        Driver.getDriver().get(ConfigReader.getProperty("hotelMyUrl"));


        HmcPage hotelMyCampPage = new HmcPage();

        hotelMyCampPage.loginButton.click();

        ReusableMethod.getActions()
                .click(hotelMyCampPage.username)
                .sendKeys(ConfigReader.getProperty("hmcUsname"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hmcpassw"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        Assert.assertTrue(hotelMyCampPage.girisBasarili.isDisplayed());

        //hotelMyCampPages.username.sendKeys(ConfigReader.getProperty("usernameHotel"));
        //hotelMyCampPages.password.sendKeys(ConfigReader.getProperty("passwordHotel"));
        //hotelMyCampPages.submit.click();
    }
}
