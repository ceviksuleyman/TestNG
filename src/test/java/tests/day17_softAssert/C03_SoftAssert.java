package tests.day17_softAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TBBeforeMethodAfterMethod;

public class C03_SoftAssert extends TBBeforeMethodAfterMethod {

    /*
    softAssert baslangic ve bitis satirlari arasindaki tum assertion'lari yapip bitis olarak
    belirtmemiz gereken assertAll() method'u ile test method'umuzdaki butun assertion'lari
    kontrol eder.Fail olan olursa sonuna assertion yaptigimiz method'un sonuna yazdigimiz
    mesaji konsolda verir.
     */
    @Test
    public void test01() {

        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");


        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"), "Girilen Kelimeyi Icermiyor");


        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled(), "Arama kutusuna erisilemedi");


        //4-arama kutusuna Nuella yazıp aratın
        searchBox.sendKeys("Nutella", Keys.ENTER);


        //5-arama yapıldıgını test edin
        WebElement nutellaAramaSonucu = driver.findElement(By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small"));
        softAssert.assertTrue(nutellaAramaSonucu.isDisplayed(), "Nutella Arama yapilamadi");


        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(nutellaAramaSonucu.getText().contains("Nutella"), "Arama Sonucu Nutella icermiyor");


        softAssert.assertAll(); // Burayi UNUTMAAAA!  Hata var ise burda bitirir sonraki satirlar calismaz.
        System.out.println("Hata varsa Burasi Calismaz");
    }
}
