package tests.aPractice.practice08;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuappPage;
import utilities.Driver;


public class P01 {

    //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    //Click all the buttons and verify they are all clicked

    HerokuappPage page;
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() {

        Driver.getDriver().get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        page = new HerokuappPage();

        //Click all the buttons and verify they are all clicked

        page.onBlur.click();
        page.onClick.click();
        page.onClick.click();
        actions.contextClick(page.onContextMenu).
                doubleClick(page.onDoubleClick).
                click(page.onFocus).
                click(page.onKeyDown).sendKeys(Keys.ENTER).
                click(page.onKeyUp).sendKeys(Keys.ENTER).
                click(page.onKeyPress).sendKeys(Keys.ENTER).
                moveToElement(page.onMouseOver).
                dragAndDrop(page.onMouseLeave, page.onMouseDown).
                click(page.onMouseDown).
                perform();

    }

    @Test(dependsOnMethods = "test01")
    public void test02() {

        Assert.assertEquals(page.eventTriggered.size(), 11);
        Driver.closeDriver();

    }
}