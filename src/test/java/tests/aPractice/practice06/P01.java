package tests.aPractice.practice06;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DhtmlgoodiesPage;
import utilities.Driver;

public class P01 {

    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.

    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        DhtmlgoodiesPage dhtmlgoodiesPage = new DhtmlgoodiesPage();


        Driver.getActions().dragAndDrop(dhtmlgoodiesPage.oslo, dhtmlgoodiesPage.norway).
                dragAndDrop(dhtmlgoodiesPage.stockholm, dhtmlgoodiesPage.swedan).
                dragAndDrop(dhtmlgoodiesPage.washington, dhtmlgoodiesPage.unitedStates).
                dragAndDrop(dhtmlgoodiesPage.copenhagen, dhtmlgoodiesPage.denmark).
                dragAndDrop(dhtmlgoodiesPage.seoul, dhtmlgoodiesPage.southKorea).
                dragAndDrop(dhtmlgoodiesPage.rome, dhtmlgoodiesPage.italy).
                dragAndDrop(dhtmlgoodiesPage.madrid, dhtmlgoodiesPage.spain).perform();

        Thread.sleep(3000);
        Driver.closeDriver();
        /*
        Fremaworkler buyudukce yeni class'lar yeni test method'lari yeni WE'ler olusturdukca icinden cikilmaz
        anlasilmaz,tekrar bakimi yapilamaz,guncellemesi cok zor hatta imkansiz bir hal alir
        uzmanlar reusable maintainable, rahat manipule edilebilir bir framework icin dir design pattern olarak
        POM(Page Object Model) de karar vermisler
        olmazsa olmazlar
        1-driver class
        2-page class
        3-test class
        utilites
        Aradigimiz bir WE ya da method'u kolaylikla bulabilmek ve guncelleyebilmek icin Java'dan ogrenmis oldugumuz
        OOP concept selenium ile Page Object Model'de birlestirilmis oluyor.
         */
    }
}
