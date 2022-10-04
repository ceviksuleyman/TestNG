package tests.day18_ConfigReaderProperties;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_PageClassFacebookTest {

    @Test
    public void testFaceBook() {
        //https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");


        //POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin


        //Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.email.sendKeys(ConfigReader.getProperty("fbWrongEmail"));
        facebookPage.password.sendKeys(ConfigReader.getProperty("fbWrongPassword"));
        facebookPage.signInButton.click();


        //Basarili giris yapilamadigini test edin
        try {
            String actualText = facebookPage.girisYapilamadi.getText();
            String expexted = "Girdiğin e-posta bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
            Assert.assertEquals(expexted, actualText);

        } catch (Exception e) {
            System.out.println(facebookPage.evetBenimDevam.getText());
            facebookPage.evetBenimDevam.click();

        }

        Driver.closeDriver();
    }
}
