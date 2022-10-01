package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Rm {


    static Faker faker;
    static Actions actions;
    static SoftAssert softAssert;
    static Select select;

    public static Faker getFaker() { // getFaker method

        return faker = new Faker();
    }//

    public static Actions getActions() { //getActions method

        return actions = new Actions(Driver.getDriver());
    }//

    public static SoftAssert getSoftAssert() { //getSoftAssert method

        return softAssert = new SoftAssert();
    }//

    public static Select select(WebElement ddm) { //select method

        return select = new Select(ddm);
    }//
}
