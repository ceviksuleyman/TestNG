package tests.aPractice.practice09;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class SearchProductTest extends TestBaseRapor {

    AutoExercisePage page = new AutoExercisePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() {

        extentTest = extentReports.createTest("autoExercise", "Web automation product search test");

        // 1. Tarayıcıyı başlat
        // 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));
        extentTest.info("sayfaya gidildi");

        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(page.homePage.isDisplayed());
        extentTest.info("Anasayfa basariyla goruntulendi");


        // 4. 'Ürünler' butonuna tıklayın
        page.productMenu.click();
        extentTest.info("Urunler butonuna tiklandi");


        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        Assert.assertTrue(page.allProductPage.isDisplayed());
        page.allProductsList.forEach(t -> System.out.println(t.getText()));
        extentTest.info("Tum urunler sayfasina basariyla ulasildi");


        // 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        actions.click(page.productSearchBox).sendKeys("blue top").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Arama kutusuna urun adi girildi ve arandi");


        // 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
        Assert.assertTrue(page.searchedProducts.isDisplayed());
        extentTest.info("Aranan urunler goruntulendi");


        // 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın
        Assert.assertTrue(page.searchedProductNames.getText().contains("Blue Top"));
        extentTest.info("Aranan urun goruntulendi");

        extentTest.pass("test bitti");
    }
}