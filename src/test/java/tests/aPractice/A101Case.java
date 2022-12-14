package tests.aPractice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.A101Page;
import utilities.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class A101Case extends TestBaseRapor {

    @Test
    public void a101Case() throws IOException, InterruptedException {


        //1-A101 Anasayfasina gidilir
        extentTest = extentReports.createTest("A101 Otomasyon", "Uctan uca odeme sistemi");
        Driver.getDriver().get(ConfigReader.getProperty("A101Url"));
        extentTest.info("A101 anasayfasina gidildi");
        A101Page a101Page = new A101Page();
        ReusableMethods.waitFor(2);
        a101Page.cookiesAccept.click(); // Cookies'i kabul et


        //2-Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
        a101Page.giyimAksesuarButonu.click();
        extentTest.info("Giyim-Aksesuar butonu tiklanir");
        a101Page.kadinIcGiyimButonu.click();
        extentTest.info("Kadin ic giyim butonu tiklanir");
        ReusableMethods.waitFor(3);
        a101Page.dizAltiCorapButonu.click();
        extentTest.info("Dizalti corap bolumune girilir");
        a101Page.siyahCorapButonu.click();
        extentTest.info("Siyah corap butonuna tiklanir");


        //3-Acilan urunun siyah oldugu dogrulanir
        String acilanCorabRengi = a101Page.corapRenkKontrol.getText(); // acilan urunun rengini getText methodu ile alip
        // bir konteynira atadik
        Assert.assertTrue(acilanCorabRengi.contains("SİYAH")); // urunun siyah olduğu kontrol edilir
        extentTest.info("urunun siyah oldugu kontrol edilir");
        ReusableMethods.getScreenshot("CorapRenkKotrolu");
        // urunun fotografi çekilerek test teyit edilmistir
        // fotografin kaydedildigi dosya test ismi, tarih ve saat olarak kayit olacaktir


        //4-Sepete ekle butonuna tiklanir
        ReusableMethods.waitFor(2);
        a101Page.corabiSepeteEkleButonu.click();
        extentTest.info("Sepete ekle butonuna tiklanir");


        //5-Sepeti Goruntule butonuna tiklanir
        a101Page.sepetiGoruntuleButonu.click();
        extentTest.info("Sepeti goruntule butonuna tiklanir");


        //6-Sepeti onayla butonuna tiklanir
        a101Page.sepetiOnaylaButonu.click();
        extentTest.info("Sepeti onayla butonuna tiklanir");


        //7-Uye olmadan devam et butonuna tiklanir
        ReusableMethods.waitFor(2);
        a101Page.uyeOlmadanDevamEtButonu.click();
        extentTest.info("Uye olmadan devam et butonuna tiklanir");


        //8-Mail ekranı gelir. Ekranın geldiği doğrulanır ve bir mail adresi girilir.
        ReusableMethods.waitFor(2);
        Assert.assertTrue(a101Page.mailTextBox.isDisplayed()); // mail kutusunun gorunur oldugu test edlir
        a101Page.mailTextBox.sendKeys(ConfigReader.getProperty("mail"));
        a101Page.mailTextBoxDevamEtButonu.click();
        extentTest.info("mail ekraninin gorunur oldugu test edilir ve bir mail adresi girilir");


        //9-Adres ekrani gelir, adres olustur dedikten sonra odeme ekrani gelir
        a101Page.adresOlusturButonu.click();
        a101Page.adresOlusturAdresBasligiBox.sendKeys(ReusableMethods.getFaker().address().city());
        a101Page.adresOlusturIsimBox.sendKeys(ReusableMethods.getFaker().name().firstName());
        a101Page.adresOlusturSoyadBox.sendKeys(ReusableMethods.getFaker().name().lastName());
        ReusableMethods.waitFor(3);
        a101Page.adresOlusturCepTelBox.sendKeys(ReusableMethods.getFaker().number().digits(11));
        extentTest.info("Adres ekrani gelir, adres olustur dedikten sonra odeme ekrani gelir");

        //Sehir Sec
        Select select;
        select = new Select(a101Page.adresOlusturIlDropDown);
        List<WebElement> IlSayisi = select.getOptions(); //DropDown menudeki tum illeri liste attik
        Random random = new Random();
        int index = random.nextInt(IlSayisi.size());
        while (index == 0) {
            index = random.nextInt(IlSayisi.size());    // random olarak il atamasi yapmasini sagladik
        }
        select.selectByIndex(index);


        // Ilce Sec
        select = new Select(a101Page.adresOlusturIlceDropDown); //DropDown menuden random olarak
        List<WebElement> ilceSayisi = select.getOptions();      //secilen ile bagli olarak ilceleri liste attik
        random = new Random();
        index = random.nextInt(ilceSayisi.size());
        while (index == 0) {
            index = random.nextInt(ilceSayisi.size());     // random olarak ilce atamasi yapmasini sagladik
        }
        select.selectByIndex(index);


        // Mahalle Sec
        select = new Select(a101Page.adresOlusturMahalleDropDown); //DropDown menuden random olarak
        List<WebElement> mahalleSayisi = select.getOptions(); //secilen ilceye bagli olarak mahalleleri liste attik
        random = new Random();
        index = random.nextInt(mahalleSayisi.size());
        while (index == 0) {
            index = random.nextInt(mahalleSayisi.size());
        }
        //Mahalle Drop Down'ında StaleElementReferenceException verdigi icin bu sekilde Handle edildi
        for (int retry = 0; retry < 10; retry++) {
            try {
                select.selectByIndex(index);
                break;
            } catch (StaleElementReferenceException e) {
                e.toString();
            }
        }


        //full adress
        Actions actions = new Actions(Driver.getDriver());
        actions.click(a101Page.adresOlusturAdresBox).
                sendKeys(ReusableMethods.getFaker().address().fullAddress())
                .perform();


        // adress bilgileri kaydet
        ReusableMethods.clickJse(a101Page.adresBilgileriniKaydet);

        //kargo secim
        //for (int retry = 0; retry < 5; retry++) {
        //    try {
        //        if (!a101Page.kargo.isSelected()) a101Page.kargo.click();
        //        break;
        //    } catch (StaleElementReferenceException ex) {
        //        ex.toString();
        //    }
        //}
        for (int i = 0; i < a101Page.cargo.size(); i++) {
            ReusableMethod.driverWait(Driver.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(a101Page.cargo.get(i)));
            a101Page.cargo.get(i).click();
            ReusableMethod.waitFor(1);
        }

        //kaydet ve devam et
        ReusableMethods.clickJse(a101Page.kaydetveDevamEt);
        ReusableMethods.waitFor(2);


        ReusableMethods.waitFor(3);
        //10-Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiğini ,doğru ekrana yönlendiklerini kontrol edecekler.

        int krediKartiHaneSayisi = 16;
        //faker classini kullanarak kart bilgilerini doldurduk.
        actions.click(a101Page.kartBilgileriAdSoyad)
                .sendKeys(ReusableMethods.getFaker().name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().number().digits(krediKartiHaneSayisi)).perform();
        extentTest.info("Ad Soyad ve Kart Numarasi bilgileri doldurulur");


        select.selectByIndex(index);
        select = new Select(a101Page.sonKullanmaTarihiAyDropDown);
        List<WebElement> ayListesi = select.getOptions();
        random = new Random();
        index = random.nextInt(ayListesi.size());
        while (index == 0) {
            index = random.nextInt(ayListesi.size());
        }


        extentTest.info("Random olarak bir ay girilir");
        select.selectByIndex(index);
        select = new Select(a101Page.sonKullanmaTarihiYilDropDown);
        List<WebElement> yilListesi = select.getOptions();
        random = new Random();
        index = random.nextInt(yilListesi.size());
        while (index == 0) {
            index = random.nextInt(yilListesi.size());
        }

        extentTest.info("Random olarak bir yil girilir");


        int cvv = 3;
        a101Page.krediKartiCvv.sendKeys(ReusableMethods.getFaker().number().digits(cvv));
        extentTest.info("Random olarak CVV girilir");

        //Odeme ekranında olundugu kontrol edilir
        String expectedText = "Kart ile ödeme";
        String actualText = a101Page.kartIleOdemeText.getText();
        Assert.assertEquals(actualText, expectedText);
        extentTest.info("Odeme ekranında olundugu kontrol edilir");


        // on bilgi
        ReusableMethods.driverWait(Driver.getDriver(), Duration.ofSeconds(15)).
                until(ExpectedConditions.elementToBeClickable(a101Page.onBilgileriKabul)).click();


        ReusableMethods.waitFor(3);
        extentTest.info("On bilgileri kabul secenegi tiklandi.");

        try {

            a101Page.mesafeliSatisSozlesmesi.click();
        } catch (Exception e) {

            ReusableMethods.jsclick(a101Page.mesafeliSatisSozlesmesi);
        }

        extentTest.info("Cıkan mesafeli satis sözlesmesi kapatildi.");

        a101Page.siparisiTamamlaButton.sendKeys(Keys.ENTER);

        extentTest.info("Siparisi tamamla butonu tiklandi.");

        ReusableMethods.getSoftAssert().assertTrue(a101Page.kartBilgileriniKontrolEdiniz.isDisplayed());

        extentTest.info("Siparis bilgilerinin dogru olmadıgı kart bilgilerini kontrol ediniz yazisi uzerinden dogrulandi.");


        ReusableMethods.getSoftAssert().assertAll();
        ReusableMethods.waitFor(5);
        Driver.closeDriver();

        extentTest.info("Sayfa kapatildi.");

        extentTest.pass("Test Başarılı.");
    }
}
