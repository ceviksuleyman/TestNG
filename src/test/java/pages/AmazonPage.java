package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage() { //constructor olusturup public yapmamiz gerekiyor

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;
    @FindBy(css = ".a-section.a-spacing-small.a-spacing-top-small")
    public WebElement aramaSonucu;

    @FindBy(css = ".a-section.a-spacing-small.a-spacing-top-small")
    public WebElement aramaSonucuWE;
}
