package tests.aPractice.autoExercise;

import com.mongodb.LazyDBDecoder;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TC23 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' url'sine gidin
    //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    //4. 'Kayıt Ol / Giriş Yap' düğmesini tıklayın
    //5. Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
    //6. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
    //7. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
    //8. Sepete ürün ekleyin
    //9. 'Sepet' düğmesini tıklayın
    //10. Sepet sayfasının görüntülendiğini doğrulayın
    //11. Ödemeye Devam Et'e tıklayın
    //12. Teslimat adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
    //13. Fatura adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
    //14. 'Hesabı Sil' düğmesini tıklayın
    //15. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın

    AutoExercisePage page = new AutoExercisePage();
    String gender = "";
    List<String> adresBilgileri = new ArrayList<>(Arrays.asList(gender + " Ayse Can",
            "Techpro",
            "Turkiye/Ankara",
            "Turkiye/Istanbul",
            "Istanbul Uskudar 34",
            "9433545455"));


    @Test
    public void testCase23() {


        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));


        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.homePage.isDisplayed(), "Anasayfa goruntulenemedi");


        //4. 'Kayıt Ol / Giriş Yap' düğmesini tıklayın
        ReusableMethod.jsScrollClick(page.loginAndSignIn);


        //5. Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
        page.newUserName.sendKeys("Ayse Can");
        page.newUserEmail.sendKeys(ReusableMethod.getFaker().internet().emailAddress());
        page.signUpButton.click();


        //gender
        for (WebElement gender : page.gender) {
            gender.click();
            ReusableMethod.waitFor(2);
        }
        gender = page.gender.get(1).getText();


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


        //
        ReusableMethod.getActions()
                .click(page.newsLetter).sendKeys(Keys.TAB)
                .click(page.partners).sendKeys(Keys.TAB)
                .sendKeys("Ayse").sendKeys(Keys.TAB)
                .sendKeys("Can").sendKeys(Keys.TAB)
                .sendKeys("Techpro").sendKeys(Keys.TAB)
                .sendKeys("Turkiye/Ankara").sendKeys(Keys.TAB)
                .sendKeys("Turkiye/Istanbul").sendKeys(Keys.TAB).perform();

        //countries
        List<WebElement> countries = ReusableMethod.select(page.country).getOptions();
        index = ReusableMethod.random().nextInt(countries.size());
        while (index == 0) {
            index = ReusableMethod.random().nextInt(countries.size());
        }
        ReusableMethod.select(page.country).selectByIndex(index);
        String country = ReusableMethod.select(page.country).getFirstSelectedOption().getText(); // secilen ulke
        System.out.println(ReusableMethod.select(page.country).getFirstSelectedOption().getText());


        ReusableMethod.jsScroll(page.state);
        ReusableMethod.getActions()
                .click(page.state).sendKeys("Uskudar").sendKeys(Keys.TAB)
                .sendKeys("Istanbul").sendKeys(Keys.TAB)
                .sendKeys("34").sendKeys(Keys.TAB)
                .sendKeys("9433545455").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //6. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
        ReusableMethod.getSoftAssert().assertTrue(page.accountCreated.isDisplayed(), "Hesap Olusturuldu goruntulenemedi");
        //continue
        page.countinue.click();


        //7. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.loggedInAs.isDisplayed(), "Kullanici adi oturum acti ifadesi gorunmedi");


        //8. Sepete ürün ekleyin
        int urun = ReusableMethod.random().nextInt(page.addToCartList.size());
        while (urun == 0) {

            urun = ReusableMethod.random().nextInt(page.addToCartList.size());
        }
        ReusableMethod.jsScrollClick(page.addToCartList.get(urun));


        //9. 'Sepet' düğmesini tıklayın
        page.viewCart.click();

        //10. Sepet sayfasının görüntülendiğini doğrulayın
        assert page.cartPage.isDisplayed();

        //11. Ödemeye Devam Et'e tıklayın
        page.proceedToCheckout.click();


        adresBilgileri = new ArrayList<>(Arrays.asList(gender + " Ayse Can",
                "Techpro",
                "Turkiye/Ankara",
                "Turkiye/Istanbul",
                "Istanbul Uskudar 34",
                "9433545455"));

        //12. Teslimat adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
        adresBilgileri.add(country); // random secilen ulke adressBilgilerine eklendi.
        System.out.println("Girilen Adress Bilgileri\n" + adresBilgileri);

        System.out.println("Teslimat Adresi***********");
        for (int i = 1; i <= adresBilgileri.size(); i++) {  //index 1 den baslattik cunku baslik yazisini almamak icin

            //List<String> address = Collections.singletonList(Arrays.toString(page.deliveryAdress.get(i).getText().split(" ")));
            //System.out.println(address);

            System.out.println(page.deliveryAdress.get(i).getText());
            Assert.assertTrue(adresBilgileri.contains(page.deliveryAdress.get(i).getText()));
        }


        //13. Fatura adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın
        System.out.println("Fatura Adresii *********");
        for (int i = 1; i <= adresBilgileri.size(); i++) {  //index 1 den baslattik cunku baslik yazisini almamak icin


            System.out.println(page.billingAdress.get(i).getText());
            Assert.assertTrue(adresBilgileri.contains(page.billingAdress.get(i).getText()));
        }


        //14. 'Hesabı Sil' düğmesini tıklayın


        //15. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın

    }
}