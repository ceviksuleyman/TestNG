package tests.aPractice.Practice05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TBBeforeClassAfterClass;

import java.time.Duration;

public class P01 extends TBBeforeClassAfterClass {
    @Test
    public void test01() throws InterruptedException {
        // ...Exercise3...

        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");


        //Cerez
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cookiesWait = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cookieChoiceDismiss")));
        cookiesWait.click();


        //fill the firstname
        driver.findElement(By.cssSelector("*[name=firstname]")).sendKeys(faker.name().firstName());


        //fill the lastname
        driver.findElement(By.cssSelector("*[name=lastname]")).sendKeys(faker.name().lastName());


        //check the gender
        WebElement gender = driver.findElement(By.cssSelector("input[value=Male]"));
        if (!gender.isSelected()) gender.click();


        //check the experience
        driver.findElement(By.cssSelector("*[id=exp-3]")).click();


        //fill the date
        driver.findElement(By.cssSelector("#datepicker")).sendKeys(tarih2);


        //choose your profession -> Automation Tester
        WebElement profession = driver.findElement(By.cssSelector("#profession-1"));
        if (!profession.isSelected()) profession.click();


        //choose your tool -> Selenium Webdriver
        WebElement tool = driver.findElement(By.cssSelector("#tool-2"));
        if (!tool.isSelected()) tool.click();


        //choose your continent -> Antartica
        WebElement continent = driver.findElement(By.cssSelector("#continents"));
        select =new Select(continent);
        select.selectByIndex(6);


        //choose your command  -> Browser Commands   #selenium_commands>:nth-child(1)
        WebElement command = driver.findElement(By.cssSelector("#selenium_commands"));
        select = new Select(command);
        select.selectByIndex(0);


        //dosya yukle
        WebElement uploadFile = driver.findElement(By.cssSelector("#photo"));
        uploadFile.sendKeys(
                "C:\\Users\\User\\IdeaProjects\\com.B81TestNG\\src\\test\\java\\tests\\aPractice\\dependsOnMethods.png");


        //click submit button
        driver.findElement(By.cssSelector("#submit")).click();
    }
}
