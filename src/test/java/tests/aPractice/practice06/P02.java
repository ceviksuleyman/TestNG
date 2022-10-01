package tests.aPractice.practice06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utilities.Driver;
import utilities.Rm;

import java.util.*;

public class P02 {
    @Test
    public void test01() {
        //     * Navigate to  https://www.saucedemo.com/
        Driver.getDriver().get("https://www.saucedemo.com/");
        //     * Enter the username  as standard_user
        //     * Enter the password as   secret_sauce
        //     * Click on login button

        SaucedemoPage saucedemoPage = new SaucedemoPage();
        saucedemoPage.username.sendKeys("standard_user");
        saucedemoPage.password.sendKeys("secret_sauce");
        saucedemoPage.loginButton.click();

        //     * Choose price low to high
        //       and verify that PRICE (LOW TO HIGH) is visible
        WebElement ddm = saucedemoPage.dropDown;


        WebElement prices = saucedemoPage.prices;
        List<WebElement> price = Driver.getDriver().findElements(By.cssSelector(".inventory_item_price"));
        Set<Double> priceSet = new TreeSet<>(); // set
        List<Double> priceList = new ArrayList<>(); // list
        for (WebElement w : price) {
            //System.out.println(w.getText() + "\n");
            priceList.add(Double.parseDouble(w.getText().replace("$", "")));
            priceSet.add(Double.parseDouble(w.getText().replace("$", "")));
        }
        System.out.println("Set Unique price -> " + priceSet);
        Collections.sort(priceList); // list'i natural sirala
        System.out.println("List Unique Degil -> " + priceList);


        Rm.select(ddm).selectByVisibleText("Price (low to high)");
        Assert.assertTrue(Rm.select(ddm).getFirstSelectedOption().isDisplayed());


        System.out.println(Rm.select(ddm).getFirstSelectedOption().getText()); //Price (low to high)


        Assert.assertEquals(Rm.select(ddm).getFirstSelectedOption().getText(), "Price (low to high)");
    }
}
