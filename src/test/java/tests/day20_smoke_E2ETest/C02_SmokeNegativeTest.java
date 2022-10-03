package tests.day20_smoke_E2ETest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Rm;

public class C02_SmokeNegativeTest {

    HmcPage hmcPage;
    @Test(groups = "grup1")
    public void invalidUser() {  //gecersiz kullanici ismi

        Driver.getDriver().get(ConfigReader.getProperty("hotelMyUrl"));
        hmcPage = new HmcPage();

        hmcPage.loginButton.click();

        Rm.getActions()
                .click(hmcPage.username)
                .sendKeys(ConfigReader.getProperty("InvalidUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hmcpassw"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        Assert.assertTrue(hmcPage.hataliGiris.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void invalidPassword() { //gecersiz parola

        Driver.getDriver().get(ConfigReader.getProperty("hotelMyUrl"));
        hmcPage = new HmcPage();

        hmcPage.loginButton.click();

        Rm.getActions()
                .click(hmcPage.username)
                .sendKeys(ConfigReader.getProperty("hmcUsname"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("InvalidPassword"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        Assert.assertTrue(hmcPage.hataliGiris.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void invalidUsPass() { //gecersiz parola ve kullanici ismi

        Driver.getDriver().get(ConfigReader.getProperty("hotelMyUrl"));
        hmcPage = new HmcPage();

        hmcPage.loginButton.click();

        Rm.getActions()
                .click(hmcPage.username)
                .sendKeys(ConfigReader.getProperty("InvalidUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("InvalidPassword"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        Assert.assertTrue(hmcPage.hataliGiris.isDisplayed());

        Driver.closeDriver();
    }

}
