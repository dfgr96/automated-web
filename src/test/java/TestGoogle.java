import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestGoogle {

    public WebDriver driver;
    public FindElements findElements;
    public String baseUrl;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://google.com/";
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleSearch() throws IOException, ParseException, InterruptedException {
        Object ob = new JSONParser().parse(new FileReader("src/test/resources/datos.json"));
        JSONObject js = (JSONObject) ob;
        findElements = new FindElements(driver);
        findElements.setInputGoogle(js.get("firstName").toString());
        //driver.quit();
    }
}
