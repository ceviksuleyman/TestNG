package tests.aPractice.autoExercise;

import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class TC04 {
    /*
     1. Tarayıcıyı başlatın
     2. 'http://automationexercise.com' url'sine gidin
     3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
     4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
     5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
     6. Doğru e-posta adresini ve şifreyi girin
     7. 'Giriş' düğmesini tıklayın
     8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
     9. 'Çıkış' düğmesini tıklayın
     10. Kullanıcının giriş sayfasına yönlendirildiğini doğrulayın
     */

    AutoExercisePage page;

    @Test
    public void testCase04() {

        page = new AutoExercisePage();

        //'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //Ana sayfanın başarıyla görünür olduğunu doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.homePage.isDisplayed(),"Anasayfa goruntulenemedi");

        //'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        page.loginAndSignIn.click();

        //'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.loginPage.isDisplayed(),"Login sayfasi goruntulenemedi");

        //Doğru e-posta adresini ve şifreyi girin
        //'Giriş' düğmesini tıklayın
        page.loginEmail.sendKeys(ConfigReader.getProperty("autoEmail"));
        page.loginPassword.sendKeys(ConfigReader.getProperty("autoPassword"));
        page.loginButton.click();

        //'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.loggedInAs.isDisplayed(),"Kullanici Adiyla giris yapilamadi");

        //'Çıkış' düğmesini tıklayın
        page.logOut.click();

        //Kullanıcının giriş sayfasına yönlendirildiğini doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.loginPage.isDisplayed(),"Giris sayfasi goruntulenemedi");


        ReusableMethod.getSoftAssert().assertAll();
        Driver.closeDriver();
    }
}
