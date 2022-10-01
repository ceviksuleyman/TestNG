package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.A101Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class A101Case extends TestBaseRapor {

    @Test
    public void a101Case() throws IOException {


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


        //6Sepeti onayla butonuna tiklanir
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
        a101Page.adresOlusturAdresBasligiBox.sendKeys("Ev Adresi");
        a101Page.adresOlusturIsimBox.sendKeys("isim");
        a101Page.adresOlusturSoyadBox.sendKeys("soyad");
        ReusableMethods.waitFor(3);
        a101Page.adresOlusturCepTelBox.sendKeys("5054443322");
        extentTest.info("Adres ekrani gelir, adres olustur dedikten sonra odeme ekrani gelir");
        Select select;
        select = new Select(a101Page.adresOlusturIlDropDown);
        List<WebElement> IlSayisi = select.getOptions(); //DropDown menudeki tum illeri liste attik
        Random random = new Random();
        int index = random.nextInt(IlSayisi.size());
        while (index == 1) {
            index = random.nextInt(IlSayisi.size());    // random olarak il atamasi yapmasini sagladik
        }

        select.selectByIndex(index);
        select = new Select(a101Page.adresOlusturIlceDropDown); //DropDown menuden random olarak
        List<WebElement> ilceSayisi = select.getOptions();      //secilen ile bagli olarak ilceleri liste attik
        random = new Random();
        index = random.nextInt(ilceSayisi.size());
        while (index == 1) {
            index = random.nextInt(ilceSayisi.size());     // random olarak ilce atamasi yapmasini sagladik
        }

        select.selectByIndex(index);
        select = new Select(a101Page.adresOlusturMahalleDropDown); //DropDown menuden random olarak
        List<WebElement> mahalleSayisi = select.getOptions();    //secilen ilceye bagli olarak mahalleleri liste attik
        random = new Random();
        index = random.nextInt(mahalleSayisi.size());
        while (index == 1) {
            index = random.nextInt(mahalleSayisi.size());
        }

        //Mahalle Drop Down'ında StaleElementReferenceException verdigi icin bu sekilde Handle edildi
        for (int retry = 0; retry < 5; retry++) {
            try {
                select.selectByIndex(index);
                break;
            } catch (StaleElementReferenceException e) {
                e.toString();
            }
        }

        Faker faker = new Faker();


        //*******************************************************************************************************

        Actions actions = new Actions(Driver.getDriver());
        actions.click(a101Page.adresOlusturAdresBox).
                sendKeys(faker.address().fullAddress())
                //.sendKeys(Keys.TAB)
                //.sendKeys(Keys.ENTER)
                .perform();

        // a101Page.adresOlusturAdresBox.sendKeys(faker.address().fullAddress());
        // ReusableMethods.clickWithJS(a101Page.adresOlusturKaydetButonu);


        ReusableMethods.clickWithJS(a101Page.kargoKaydetVeDevamButonu);

        ReusableMethods.waitFor(2);
        //JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //try {
        //    ReusableMethods.clickWithJS(a101Page.kargoKaydetVeDevamButonu);
        //} catch (Exception e) {
        //    jse.executeScript("arguments[0].scrollIntoView(true);", a101Page.kargoKaydetVeDevamButonu);
        //    jse.executeScript("arguments[0].click()", a101Page.kargoKaydetVeDevamButonu);
        //}

        ReusableMethods.waitFor(2);

        //************************************************************************************************************
        //kargo secim
        if (!a101Page.kargo.isSelected()) a101Page.kargo.click();

        ReusableMethods.waitFor(2);

        /*
         * Buradan aşağıdaki kısımda ise ödeme ekranı bilgilerinin doğruluğu kısmında yanlış bilgi sonucu çıkan mesaj işlemi yapıldı.
         //Ödeme ekranındaki bölümleri geçersiz olarak giriş yapılıp hata mesajı aldığını kontrol ediniz
         //Ad soyad
         driver.findElement(By.xpath("(//input[@name='name'])[2]")).sendKeys("İpek Çiğdem Tan");
         Thread.sleep(3000);
         //Kart Numarasi
         driver.findElement(By.xpath("(//input[@class='js-masterpassbin-payment-card'])[1]")).sendKeys("1234 5678 9123 4567");
         Thread.sleep(3000);
         //son kullanma tarihi
         driver.findElement(By.xpath("(//select[@name='card_month'])[2]")).sendKeys("2",Keys.ENTER);
         Thread.sleep(3000);
         driver.findElement(By.xpath("(//select[@name='card_year'])[2]")).sendKeys("2026",Keys.ENTER);
         Thread.sleep(3000);
         //ccv
         driver.findElement(By.xpath("(//input[@name='card_cvv'])[2]")).sendKeys("136",Keys.ENTER);
         Thread.sleep(3000);
         //Ön bilgileri kabul etme butonu
         driver.findElement(By.xpath("(//label[@for='agrement2'])[1]")).click();
         Thread.sleep(5000);
         //siparişi tamamla
         driver.findElement(By.xpath("(//span[text()='Siparişi Tamamla'])[2]")).click();
         Thread.sleep(5000);
         //Kart bilgilerini doğru giriniz yazısının geldiğini doğrulayınız
         Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Kart bilgilerinizi kontrol ediniz.']")).isDisplayed());
         */

        //ReusableMethods.clickWithJS(a101Page.kargoKaydetVeDevamButonu);
        //10-Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiğini ,doğru ekrana yönlendiklerini kontrol edecekler.
    }
}
