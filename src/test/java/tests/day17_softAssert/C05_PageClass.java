package tests.day17_softAssert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C05_PageClass {

    @Test
    public void test01() {

        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get("https://www.amazon.com");

        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        System.out.println(amazonPage.aramaSonucu.getText());
    }
}
