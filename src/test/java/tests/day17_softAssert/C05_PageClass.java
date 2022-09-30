package tests.day17_softAssert;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C05_PageClass {

    @Test
    public void test01() {

        AmazonPage amazonPage = new AmazonPage(); // amazonPage obje


        //amazon'a git
        Driver.getDriver().get("https://www.amazon.com");


        //nutella ara
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);


        //sonuc yazisinin "Nutella" icerdigini test et
        String actualSonuc = amazonPage.aramaSonucu.getText();
        Assert.assertTrue(actualSonuc.contains("Nutella"));
    }
}
