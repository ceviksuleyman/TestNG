package tests.aPractice.autoExercise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

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
        ReusableMethod.getSoftAssert().assertTrue(page.homePage.isDisplayed(), "Anasayfa goruntulenemedi");

        //'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        ReusableMethod.jsclick(page.loginAndSignIn);

        //'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        ReusableMethod.getSoftAssert().assertTrue(page.newUserSignupPage.isDisplayed(), "Yeni Kullanci Kaydi goruntulenemedi");

        //Adı ve e-posta adresini girin
        page.newUserName.sendKeys(ReusableMethod.getFaker().name().fullName());
        page.newUserEmail.sendKeys(ReusableMethod.getFaker().internet().emailAddress());

        //'Kaydol' düğmesini tıklayın
        page.SignupButton.click();

        //'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.accountInformation.isDisplayed(), "Hesap Bilgilerini Girin goruntulenemedi");

        // Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        //gender
        //for (int i = 0; i < exPage.gender.size(); i++) {
        //    exPage.gender.get(i).click();
        //}
        for (WebElement gender : page.gender){
            gender.click();
            ReusableMethod.waitFor(2);
        }

        //password
        page.passwordNewSignup.sendKeys(ReusableMethod.getFaker().internet().password());

        //day
        List<WebElement> days = ReusableMethod.select(page.day).getOptions();
        int index = ReusableMethod.random().nextInt(days.size());
        while (index == 0) {
            index = ReusableMethod.random().nextInt(days.size());
        }
        ReusableMethod.select(page.day).selectByIndex(index);
        System.out.println(ReusableMethod.select(page.day).getFirstSelectedOption().getText());

        //month
        List<WebElement> months = ReusableMethod.select(page.month).getOptions();
        index = ReusableMethod.random().nextInt(months.size());
        while (index == 0) {
            index = ReusableMethod.random().nextInt(months.size());
        }
        ReusableMethod.select(page.month).selectByIndex(index);
        System.out.println(ReusableMethod.select(page.month).getFirstSelectedOption().getText());

        //year
        List<WebElement> years = ReusableMethod.select(page.year).getOptions();
        index = ReusableMethod.random().nextInt(years.size());
        while (index == 0) {
            index = ReusableMethod.random().nextInt(years.size());
        }
        ReusableMethod.select(page.year).selectByIndex(index);
        System.out.println(ReusableMethod.select(page.year).getFirstSelectedOption().getText());

        //'Bültenimize kaydolun!' onay kutusunu seçin.
        //'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //'Hesap Oluştur düğmesini' tıklayın
        ReusableMethod.getActions()
                .click(page.newsLetter).sendKeys(Keys.TAB)
                .click(page.partners).sendKeys(Keys.TAB)
                .sendKeys(ReusableMethod.getFaker().name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(ReusableMethod.getFaker().name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(ReusableMethod.getFaker().company().name()).sendKeys(Keys.TAB)
                .sendKeys(ReusableMethod.getFaker().address().streetAddress()).sendKeys(Keys.TAB)
                .sendKeys(ReusableMethod.getFaker().address().fullAddress()).sendKeys(Keys.TAB).perform();

        List<WebElement> countries = ReusableMethod.select(page.country).getOptions();
        index = ReusableMethod.random().nextInt(countries.size());
        while (index == 0) {
            index = ReusableMethod.random().nextInt(countries.size());
        }
        ReusableMethod.select(page.country).selectByIndex(index);
        System.out.println(ReusableMethod.select(page.country).getFirstSelectedOption().getText());

        ReusableMethod.jsScroll(page.state);
        ReusableMethod.getActions()
                .click(page.state).sendKeys(ReusableMethod.getFaker().address().state()).sendKeys(Keys.TAB)
                .sendKeys(ReusableMethod.getFaker().address().city()).sendKeys(Keys.TAB)
                .sendKeys(ReusableMethod.getFaker().address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(ReusableMethod.getFaker().phoneNumber().cellPhone()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //'HESAP OLUŞTURULDU!' görünür
        ReusableMethod.getSoftAssert().assertTrue(page.accountCreated.isDisplayed(),"Hesap Olusturuldu goruntulenemedi");

        //'Devam' düğmesini tıklayın
        page.countine.click();

        //'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.loggedInAs.isDisplayed(),"Kullanici adi oturum acti ifadesi gorunmedi");

        //'Hesabı Sil' düğmesini tıklayın
        page.deleteAccount.click();

        //'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
        ReusableMethod.getSoftAssert().assertTrue(page.deleted.isDisplayed(),"Hesap Silinemedi");



        ReusableMethod.getSoftAssert().assertAll();
        ReusableMethod.waitFor(6);
        Driver.closeDriver();
    }
}
