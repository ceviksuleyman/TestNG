package tests.aPractice.practice07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {

    WebUniversityPage page;

    @Test
    public void test01() {

        page = new WebUniversityPage();

        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("universityUrl"));

        // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen,
        // Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
        List<String> todoList = new ArrayList<>(Arrays.asList("Bulasiklari Yika"
                , "Bebekle Ilgilen"
                , "Cocugun Odevine Yardim Et"
                , "Selenium Calis"
                , "Uyu"));

        for (int i = 0; i < todoList.size(); i++) {

            ReusableMethod.getActions().click(page.addNewTodo).sendKeys(todoList.get(i)).sendKeys(Keys.ENTER).perform();
        }


        //Tüm yapılacakların üzerini çiz.
        for (WebElement w : page.todos) {

            ReusableMethod.getActions().click(w).perform();
        }

        //Tüm yapılacakları sil.
        for (WebElement w : page.deleteTodos) {
            //Rm.getActions().moveToElement(w).perform();
            ReusableMethod.waitFor(2);
            ReusableMethod.getActions().click(w).perform();
        }


        //Tüm yapılacakların silindiğini doğrulayın.
        ReusableMethod.waitFor(2);
        System.out.println(page.todos.size());
        Assert.assertEquals(0, page.todos.size());


        Driver.closeDriver();
    }
}
