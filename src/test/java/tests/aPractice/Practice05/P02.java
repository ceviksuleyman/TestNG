package tests.aPractice.Practice05;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TBBeforeClassAfterClass;

public class P02 extends TBBeforeClassAfterClass {

    @Test
    public void test01() {
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        // 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        driver.findElement(By.cssSelector(".section-title>:nth-child(1)")).click();

        // 3. Açılır metni alın
        System.out.println(driver.switchTo().alert().getText());

        // 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        Assert.assertEquals("I am an alert box!", driver.switchTo().alert().getText());
        Assert.assertTrue(driver.switchTo().alert().getText().contains("I am an alert box!"));

        // 5. Açılır pencereyi kabul edin
        driver.switchTo().alert().accept();
    }
}
