package tests.aPractice.practice06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utilities.Driver;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        Set<Double> priceSet = new TreeSet<>();
        for (WebElement w : price) {
            //System.out.println(w.getText() + "\n");
            priceSet.add(Double.parseDouble(w.getText().replace("$", "")));
        }
        System.out.println(priceSet);


        Driver.select(ddm).selectByVisibleText("Price (low to high)");
        Assert.assertTrue(Driver.select(ddm).getFirstSelectedOption().isDisplayed());


        System.out.println(Driver.select(ddm).getFirstSelectedOption().getText()); //Price (low to high)


        Assert.assertEquals(Driver.select(ddm).getFirstSelectedOption().getText(), "Price (low to high)");
    }
}
