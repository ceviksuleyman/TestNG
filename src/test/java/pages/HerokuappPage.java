package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HerokuappPage {

    public HerokuappPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#onblur")
    public WebElement onBlur;
    @FindBy(css = "#onclick")
    public WebElement onClick;
    @FindBy(css = "#oncontextmenu")
    public WebElement onContextMenu;
    @FindBy(css = "#ondoubleclick")
    public WebElement onDoubleClick;
    @FindBy(css = "#onfocus")
    public WebElement onFocus;
    @FindBy(css = "#onkeydown")
    public WebElement onKeyDown;
    @FindBy(css = "#onkeyup")
    public WebElement onKeyUp;
    @FindBy(css = "#onkeypress")
    public WebElement onKeyPress;
    @FindBy(css = "#onmouseover")
    public WebElement onMouseOver;
    @FindBy(css = "#onmouseleave")
    public WebElement onMouseLeave;
    @FindBy(css = "#onmousedown")
    public WebElement onMouseDown;
    @FindBy(xpath = "//*[.='Event Triggered']")
    public List<WebElement> eventTriggered;

}