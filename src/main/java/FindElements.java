import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindElements {

    WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    WebElement inputGoogle;
    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]")
    WebElement submitGoogle;

    public FindElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setInputGoogle(String busqueda) throws InterruptedException {
        inputGoogle.sendKeys(busqueda);
        Thread.sleep(1000);
        submitGoogle.click();
    }
}
