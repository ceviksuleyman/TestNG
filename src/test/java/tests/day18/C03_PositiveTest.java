package tests.day18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPages;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PositiveTest {

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


        HotelMyCampPages hotelMyCampPages = new HotelMyCampPages();

        hotelMyCampPages.loginButton.click();

        Driver.getActions()
                .click(hotelMyCampPages.username)
                .sendKeys(ConfigReader.getProperty("usernameHotel"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("passwordHotel"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        Assert.assertTrue(hotelMyCampPages.girisBasarili.isDisplayed());

        //hotelMyCampPages.username.sendKeys(ConfigReader.getProperty("usernameHotel"));
        //hotelMyCampPages.password.sendKeys(ConfigReader.getProperty("passwordHotel"));
        //hotelMyCampPages.submit.click();
    }
}
