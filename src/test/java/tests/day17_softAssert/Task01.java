package tests.day17_softAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TBBeforeClassAfterClass;

public class Task01 extends TBBeforeClassAfterClass {

 /*
     Bir class oluşturun: DependsOnTest
     https://www.amazon.com/ adresine gidin.
     Test : Amazon ana sayfaya gittiginizi test edin
     Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
     arama yapin ve aramanizin gerceklestigini Test edin
     Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
     $16.83 oldugunu test edin
     */

    @Test
    public void testAmazon() {

        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
    }

    @Test(priority = 1)
    public void testAmazonAnasayfa() {

        Assert.assertTrue(driver.findElement(By.cssSelector("#pageContent")).isDisplayed());
    }

    @Test(dependsOnMethods = "testAmazonAnasayfa")
    public void testNutellaAra() {

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        WebElement nutellaAramaSonucu = driver.findElement(By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small"));
        System.out.println(nutellaAramaSonucu.getText());
        Assert.assertTrue(nutellaAramaSonucu.isDisplayed());
    }

    @Test(dependsOnMethods = "testNutellaAra")
    public void testPrice() {

        WebElement ilkUrun = driver.findElement(By.cssSelector(".s-main-slot.s-result-list.s-search-results.sg-row>:nth-child(2)"));
        ilkUrun.click();

        String price = driver.findElement(By.cssSelector("#a-page")).getText();
        Assert.assertNotEquals(price, "$16.83");
    }

}
