package tests.day19_PositiveNegativeTest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Rm;

public class C03_NegativeTest {
    /*
    https://www.hotelmycamp.com/ adresine git
    login butonuna bas
    test data username: manager1 ,
    test data password :manager1!
    Degerleri girildiginde sayfaya girilemedigini test et
     */

    @Test
    public void negativeTest() {

        HmcPage hotelMyCampPage = new HmcPage();

        Driver.getDriver().get(ConfigReader.getProperty("hotelMyUrl"));

        Rm.getActions().
                click(hotelMyCampPage.loginButton).perform();
        Rm.getActions().click(hotelMyCampPage.username).
                sendKeys(ConfigReader.getProperty("InvalidUsername")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("InvalidPassword")).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        //hotelMyCampPages.loginButton.click();
        //hotelMyCampPages.username.sendKeys(ConfigReader.getProperty("userWrongHotel"));
        //hotelMyCampPages.password.sendKeys(ConfigReader.getProperty("passwordHotel"));
        //hotelMyCampPages.submit.click();

        Rm.getSoftAssert().assertTrue(hotelMyCampPage.hataliGiris.isDisplayed());
    }
}
