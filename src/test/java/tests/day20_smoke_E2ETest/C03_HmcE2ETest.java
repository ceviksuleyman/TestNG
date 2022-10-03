package tests.day20_smoke_E2ETest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.Rm;

import java.time.Duration;

public class C03_HmcE2ETest {

    @Test
    public void e2eTest() throws InterruptedException {

        //https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyUrl"));
        //Username textbox ve password metin kutularını locate edin ve asagidaki verileri
        //Username : manager
        //Password  : Manager1!
        //Login butonuna tıklayın.
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

        //Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(14));
        wait.until(ExpectedConditions.elementToBeClickable(hmcPage.hotelManagement)).click();
        hmcPage.roomReservation.click();


        //Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        hmcPage.addRoom.click();

        hmcPage.userId.sendKeys(ConfigReader.getProperty("hmcUsname"));

        Rm.select(hmcPage.userIdHotelRoom).selectByIndex(9);

        Rm.getActions().click(hmcPage.price).sendKeys("1200")
                .sendKeys(Keys.TAB).sendKeys("10/02/2022").sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys("10/12/2022").sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().number().digit())
                .sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().number().digit())
                .sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().random().toString()).perform();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", hmcPage.approved);

        if (!hmcPage.approved.isSelected()) hmcPage.approved.click();
        if (!hmcPage.isPaid.isSelected()) hmcPage.isPaid.click();


        //Save butonuna tıklayın.
        jse.executeScript("arguments[0].scrollIntoView(true);", hmcPage.buttonSubmit);
        jse.executeScript("arguments[0].click();", hmcPage.buttonSubmit);


        //“RoomReservation was inserted successfully” textinin göründüğünü test edin.
        wait.until(ExpectedConditions.elementToBeClickable(hmcPage.reservationSuccessfullyText));
        Assert.assertTrue(hmcPage.reservationSuccessfullyText.isDisplayed());


        //OK butonuna tıklayın.
        hmcPage.okButton.click();

        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }
}
