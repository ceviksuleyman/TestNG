package tests.day18;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeTest {
    /*
    https://www.hotelmycamp.com/ adresine git
    login butonuna bas
    test data username: manager1 ,
    test data password :manager1!
    Degerleri girildiginde sayfaya girilemedigini test et
     */

    @Test
    public void negativeTest() {

        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        Driver.getDriver().get(ConfigReader.getProperty("hotelMyUrl"));

        Driver.getActions().
                click(hotelMyCampPage.loginButton).perform();
        Driver.getActions().click(hotelMyCampPage.username).
                sendKeys(ConfigReader.getProperty("userWrongHotel")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("passwordHotel")).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        //hotelMyCampPages.loginButton.click();
        //hotelMyCampPages.username.sendKeys(ConfigReader.getProperty("userWrongHotel"));
        //hotelMyCampPages.password.sendKeys(ConfigReader.getProperty("passwordHotel"));
        //hotelMyCampPages.submit.click();

        Driver.getSoftAssert().assertTrue(hotelMyCampPage.hataliGiris.isDisplayed());
    }
}
