package tests.day16_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TBBeforeClassAfterClass;

public class C04_dependsOnMethods extends TBBeforeClassAfterClass {

    @Test
    public void test1() {

        //amazon anasayfasina git
        driver.get("https://www.amazon.com");
    }

    @Test(dependsOnMethods = "test1")
    public void test2() {

        //Nutella ara
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
    }

    @Test(dependsOnMethods = "test2")
    public void test3() {

        //sonuc yazisinin 'amazon' icerdigini test et
        WebElement sonuc = driver.findElement(By.
                xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertFalse(sonuc.getText().contains("amazon"));
    }

}
