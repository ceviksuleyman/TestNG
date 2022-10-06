package tests.day23_dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class NegatifLoginDataProvider {


    BrcPage brcPage;

    @DataProvider
    public static Object[][] KullaniciListe() {

        Object[][] kullaniciBilgileri = {{"mahmut@gmail.com", "123454"},
                {"murtaza@hotmail.com", "454312"},
                {"java@gmail.com", "5634631"}};

        return kullaniciBilgileri;
    }

    @Test(dataProvider = "KullaniciListe")
    public void test01(String email, String password) {  // parametre sayisi ile each array'larin yapisi ayni olmalidir.

        brcPage = new BrcPage();

        //-https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bRCUrl"));
        ReusableMethod.waitFor(3);

        //-login butonuna bas
        brcPage.loginButton.click();

        //-test data user email: customer@bluerentalcars.com
        brcPage.emailBox.sendKeys(email);

        //-test data password : 12345 dataları girip login e basın
        brcPage.passwordBox.sendKeys(password);
        ReusableMethod.waitFor(2);

        //-login butonuna tiklayin
        brcPage.submitLogin.click();

        //kapat
        Driver.closeDriver();
    }
}
