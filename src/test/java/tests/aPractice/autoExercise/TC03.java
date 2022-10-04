package tests.aPractice.autoExercise;

import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class TC03 {
    /*
     1. Tarayıcıyı başlatın
     2. 'http://automationexercise.com' url'sine gidin
     3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
     4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
     5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
     6. Yanlış e-posta adresi ve şifre girin
     7. 'Giriş' düğmesini tıklayın
     8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
     */

    AutoExercisePage page;

    @Test
    public void testCase03() {

        page = new AutoExercisePage();

        //'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //Ana sayfanın başarıyla görünür olduğunu doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.homePage.isDisplayed(), "Anasayfa goruntulenemedi");

        //'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        page.loginAndSignIn.click();

        //'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.loginPage.isDisplayed(), "Login sayfasi goruntulenemedi");

        //Yanlış e-posta adresi ve şifre girin
        //'Giriş' düğmesini tıklayın
        page.loginEmail.sendKeys(ConfigReader.getProperty("InvalidEmail"));
        page.loginPassword.sendKeys(ConfigReader.getProperty("InvalidPassword"));
        page.loginButton.click();

        //'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        ReusableMethod.getSoftAssert().assertTrue(page.incorrectText.isDisplayed(), "Gecersiz bilgilerle giris saglanamadi mesaji goruntulenmedi");

        ReusableMethod.getSoftAssert().assertAll();

        Driver.closeDriver();
    }
}
