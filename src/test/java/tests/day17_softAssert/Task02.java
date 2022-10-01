package tests.day17_softAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TBBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task02 extends TBBeforeClassAfterClass {
    /*
     “http://zero.webappsecurity.com/” Adresine gidin
     Sign in butonuna basin
     Login kutusuna “username” yazin
     Password kutusuna “password” yazin
     Sign in tusuna basin
     Online banking menusu icinde Pay Bills sayfasina gidin
     “Purchase Foreign Currency” tusuna basin
     “Currency” drop down menusunden Eurozone u secin
     soft assert kullanarak "Eurozone (euro)" secildigini test edin
     soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
     "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
     "China (yuan)","Denmark (krone)","Eurozone (euro)",
     "Great Britain (pound)","Hong Kong  (dollar)","Japan (yen)",
     "Mexico (peso)","Norway (krone)","New Zealand (dollar)",
     "Sweden (krona)","Singapore (dollar)","Thailand (baht)"
     */

    @Test
    public void test01() {

        SoftAssert softAssert = new SoftAssert();

        //“http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");


        //Sign in butonuna basin
        driver.findElement(By.cssSelector("button[id=signin_button]")).click();


        //Login kutusuna “username” yazin
        driver.findElement(By.cssSelector("input[id=user_login]")).sendKeys("username");


        //Password kutusuna “password” yazin
        driver.findElement(By.cssSelector("input[id=user_password]")).sendKeys("password");


        //Sign in tusuna basin
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();


        //sayfa hatasindan dolayi yeniden sayfaya git.
        driver.navigate().to("http://zero.webappsecurity.com/");


        //Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("#onlineBankingMenu")).click();
        driver.findElement(By.cssSelector("#pay_bills_link")).click();



        //“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.cssSelector(".ui-tabs-nav.ui-helper-reset>:nth-child(3)")).click();


        //“Currency” drop down menusunden Eurozone u secin
        WebElement ddm = driver.findElement(By.cssSelector("#pc_currency"));
        select = new Select(ddm);
        select.selectByIndex(6);
        System.out.println("option -> " + select.getFirstSelectedOption().getText()); // Eurozone (euro)


        //soft assert kullanarak "Eurozone (euro)" secildigini test edin
        softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Eurozone (euro)", "Eurozone (euro) secilemedi");


        //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<String> expectedDdm = new ArrayList<>(Arrays.asList("Select One",
                "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)",
                "China (yuan)", "Denmark (krone)", "Eurozone (euro)",
                "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)",
                "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)",
                "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));

        List<WebElement> ddmList = select.getOptions(); // siteden gelen ddm
        ddmList.forEach(t -> System.out.println(t.getText()));

        for (int i = 0; i < ddmList.size(); i++) {

            //if (ddmList.get(i).getText().equals(expectedDdm.get(i))) { }
                softAssert.assertEquals(ddmList.get(i).getText(), expectedDdm.get(i), "Dropdown secenekleri beklenen liste ile esit degil");
        }
        softAssert.assertAll();
    }


    /*
    @Test
    public void test01() {
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        // 3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        // 4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[normalize-space()='Online Banking']")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[normalize-space()='Purchase Foreign Currency']")).click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Eurozone (euro)");
        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String secilenOption = select.getFirstSelectedOption().getText();
        String expectedOption = "Eurozone (euro)";
        softAssert.assertEquals(secilenOption,expectedOption,"Secilen option uygun degil");
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One",
        List<WebElement> dropDownList = select.getOptions();
        List<String> actualList = new ArrayList<>();
        for (WebElement w:dropDownList) {
            actualList.add(w.getText());
        }
        List<String> dropDownElement = new ArrayList<>(Arrays.asList("Select One","Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
                "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
                "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"));
        Collections.sort(dropDownElement);
        Collections.sort(actualList);
        softAssert.assertEquals(actualList,dropDownElement,"uyusmazlik var");
        softAssert.assertAll();

    }
     */
}
