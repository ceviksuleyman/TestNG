package tests.day18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
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


        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        hotelMyCampPage.loginButton.click();

        Driver.getActions()
                .click(hotelMyCampPage.username)
                .sendKeys(ConfigReader.getProperty("userHotel"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("passwordHotel"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        Assert.assertTrue(hotelMyCampPage.girisBasarili.isDisplayed());

        //hotelMyCampPages.username.sendKeys(ConfigReader.getProperty("usernameHotel"));
        //hotelMyCampPages.password.sendKeys(ConfigReader.getProperty("passwordHotel"));
        //hotelMyCampPages.submit.click();
    }
}
