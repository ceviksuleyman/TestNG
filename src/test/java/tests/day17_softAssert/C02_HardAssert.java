package tests.day17_softAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TBBeforeMethodAfterMethod;

public class C02_HardAssert extends TBBeforeMethodAfterMethod {

    /*
    Hard Assertions : JUNit'te öğrendiğimiz assertion ile aynıdır.  Assert.assertTrue(); Assert.assertFalse();  Assert.assertEquals();
    Hard Assertions'da herhangi bir assertion failed olursa, test method'un çalışmasını durdurur ve kalan kodları yürütmez.(stop execution)

    Soft Assert : Kullanabilmek için obje oluştururuz, oluşturduktan sonra obje ismi ile kullanırız, Herhangi bir hata verdiğinde test methodu
    çalışmaya devam eder, en sonra rapor verir.    baslangıc  SoftAssert objeadı=new SoftAssert();  bitis objeadı.assertAll();
     */
    @Test
    public void test01() {

        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

        //2-title in Amazon içerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());

        //4-arama kutusuna Nuella yazıp aratın
        searchBox.sendKeys("Nutella", Keys.ENTER);

        //5-arama yapıldıgını test edin .a-section.a-spacing-small.a-spacing-top-small>:nth-child(1)
        WebElement nutellaAramaSonucu = driver.findElement(By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small"));
        System.out.println(nutellaAramaSonucu.getText());
        Assert.assertTrue(nutellaAramaSonucu.isDisplayed());

        //6-arama sonucunun Nutella içerdigini test edin
        Assert.assertTrue(nutellaAramaSonucu.getText().contains("Nutella"));
    }
}
