import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


@Test
public class TestForm {

    WebDriver browser;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmad\\Documents\\webDrivers\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.get("https://forms.office.com/Pages/ResponsePage.aspx?id=DQSIkWdsW0yxEjajBLZtrQAAAAAAAAAAAAN__" +
                "tQlYTdURExDM0ZZQVBZQzIyRjQzMjNMTFk3RTYzMy4u");
        FillForm f = new FillForm(browser);
        f.fillAll();
    }

    @Test
    public void testTextField() {
        WebElement text = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div/div/div/div[2]" +
                "/div[2]/div[3]/div/div[2]/div/div/input"));
        Assertions.assertEquals("Ahmad Horyzat", text.getAttribute("value"));
    }

    @Test
    public void testCheckBox() {
        WebElement check2 = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div/div/div" +
                "/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/div/label/input"));
        Assertions.assertTrue(check2.isSelected());

        WebElement check3 = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div/div" +
                "/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/div/label/input"));
        Assertions.assertTrue(check3.isSelected());
    }

    @Test
    public  void testRadioBtn() {
        WebElement radio = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div" +
                "/div/div/div[2]/div[2]/div[6]/div/div[2]/div/div[2]/div/label/input"));
        Assertions.assertTrue(radio.isSelected());
    }

}
