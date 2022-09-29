package tests.day16_notation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TBBeforeClassAfterClass;

public class Task01 extends TBBeforeClassAfterClass {
    /*
     1) Bir class oluşturun: YoutubeAssertions
     2) https://www.youtube.com adresine gidin
     3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
     ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

    @Test(priority = 1)
    public void testYoutube() {
        driver.get("https://www.youtube.com");
    }

    @Test(dependsOnMethods = "testYoutube")
    public void testTitle() {

        Assert.assertEquals("YouTube", driver.getTitle());
    }

    @Test(dependsOnMethods = "testTitle")
    public void testImage() {

        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]")).isDisplayed());
    }

    @Test(dependsOnMethods = "testImage")
    public void testsearchBox() {
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id=search]")).isEnabled());
    }

    @Test(dependsOnMethods = "testsearchBox")
    public void testName() {

        Assert.assertNotEquals("youtube", driver.getTitle());
    }
}
