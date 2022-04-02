import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindElements {

    WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    WebElement inputGoogle;

    public FindElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setInputGoogle(String busqueda){
        inputGoogle.sendKeys(busqueda);
    }
}
