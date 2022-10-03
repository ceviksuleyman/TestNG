package tests.aPractice.autoExercise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Rm;

import java.util.List;

public class TC01 {
     /*
      1. Tarayıcıyı başlatın
      2. 'http://automationexercise.com' url'sine gidin
      3. Ana sayfanın başarılı bir şekilde görünür olduğunu doğrulayın(Ana sayfanın başarıyla görüldüğünü doğrulayın)
      4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
      5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
      6. Adı ve e-posta adresini girin
      7. 'Kaydol' düğmesini tıklayın
      8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
      9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
      10. 'Bültenimize kaydolun!' onay kutusunu seçin.
      11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
      12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
      13. 'Hesap Oluştur düğmesini' tıklayın
      14. 'HESAP OLUŞTURULDU!' görünür
      15. 'Devam' düğmesini tıklayın
      16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
      17. 'Hesabı Sil' düğmesini tıklayın
      18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
       */

    AutoExercisePage page;

    @Test
    public void registerUser() {

        page = new AutoExercisePage();

        //'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //Ana sayfanın başarılı bir şekilde görünür olduğunu doğrulayın(Ana sayfanın başarıyla görüldüğünü doğrulayın)
        Rm.getSoftAssert().assertTrue(page.homePage.isDisplayed(), "Anasayfa goruntulenemedi");

        //'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        Rm.jsclick(page.loginAndSignIn);

        //'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        Rm.getSoftAssert().assertTrue(page.newUserSignupPage.isDisplayed(), "Yeni Kullanci Kaydi goruntulenemedi");

        //Adı ve e-posta adresini girin
        page.newUserName.sendKeys(Rm.getFaker().name().fullName());
        page.newUserEmail.sendKeys(Rm.getFaker().internet().emailAddress());

        //'Kaydol' düğmesini tıklayın
        page.SignupButton.click();

        //'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        Rm.getSoftAssert().assertTrue(page.accountInformation.isDisplayed(), "Hesap Bilgilerini Girin goruntulenemedi");

        // Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        //gender
        //for (int i = 0; i < exPage.gender.size(); i++) {
        //    exPage.gender.get(i).click();
        //}
        for (WebElement gender : page.gender){
            gender.click();
            Rm.waitFor(2);
        }

        //password
        page.passwordNewSignup.sendKeys(Rm.getFaker().internet().password());

        //day
        List<WebElement> days = Rm.select(page.day).getOptions();
        int index = Rm.random().nextInt(days.size());
        while (index == 0) {
            index = Rm.random().nextInt(days.size());
        }
        Rm.select(page.day).selectByIndex(index);
        System.out.println(Rm.select(page.day).getFirstSelectedOption().getText());

        //month
        List<WebElement> months = Rm.select(page.month).getOptions();
        index = Rm.random().nextInt(months.size());
        while (index == 0) {
            index = Rm.random().nextInt(months.size());
        }
        Rm.select(page.month).selectByIndex(index);
        System.out.println(Rm.select(page.month).getFirstSelectedOption().getText());

        //year
        List<WebElement> years = Rm.select(page.year).getOptions();
        index = Rm.random().nextInt(years.size());
        while (index == 0) {
            index = Rm.random().nextInt(years.size());
        }
        Rm.select(page.year).selectByIndex(index);
        System.out.println(Rm.select(page.year).getFirstSelectedOption().getText());

        //'Bültenimize kaydolun!' onay kutusunu seçin.
        //'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //'Hesap Oluştur düğmesini' tıklayın
        Rm.getActions()
                .click(page.newsLetter).sendKeys(Keys.TAB)
                .click(page.partners).sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().company().name()).sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().address().streetAddress()).sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().address().fullAddress()).sendKeys(Keys.TAB).perform();

        List<WebElement> countries = Rm.select(page.country).getOptions();
        index = Rm.random().nextInt(countries.size());
        while (index == 0) {
            index = Rm.random().nextInt(countries.size());
        }
        Rm.select(page.country).selectByIndex(index);
        System.out.println(Rm.select(page.country).getFirstSelectedOption().getText());

        Rm.jsScroll(page.state);
        Rm.getActions()
                .click(page.state).sendKeys(Rm.getFaker().address().state()).sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().address().city()).sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(Rm.getFaker().phoneNumber().cellPhone()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //'HESAP OLUŞTURULDU!' görünür
        Rm.getSoftAssert().assertTrue(page.accountCreated.isDisplayed(),"Hesap Olusturuldu goruntulenemedi");

        //'Devam' düğmesini tıklayın
        page.countine.click();

        //'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        Rm.getSoftAssert().assertTrue(page.loggedInAs.isDisplayed(),"Kullanici adi oturum acti ifadesi gorunmedi");

        //'Hesabı Sil' düğmesini tıklayın
        page.deleteAccount.click();

        //'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
        Rm.getSoftAssert().assertTrue(page.deleted.isDisplayed(),"Hesap Silinemedi");



        Rm.getSoftAssert().assertAll();
        Rm.waitFor(6);
        Driver.closeDriver();
    }
}
