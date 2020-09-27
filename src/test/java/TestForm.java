import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestForm {

    WebDriver browser;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmad\\Documents\\webDrivers\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.get("https://forms.office.com/Pages/ResponsePage.aspx?id=DQSIkWdsW0yxEjajBLZtrQAAAAAAAAAAAAN__" +
                "tQlYTdURExDM0ZZQVBZQzIyRjQzMjNMTFk3RTYzMy4u");
    }

    @Test
    public void testTextField() {
        WebElement textField = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div" +
                "/div/div/div[2]/div[2]/div[3]/div/div[2]/div/div/input"));

        WebDriverWait wait = new WebDriverWait(browser, 45);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form-container\"]" +
                "/div/div/div/div/div[1]/div[1]/div/span")));
        textField.sendKeys("Ahmad Horyzat");

        Assertions.assertEquals("Ahmad Horyzat", textField.getAttribute("value"));
    }

    @Test
    public void testCheckBox() {
        WebElement check2 = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div" +
                "/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/div/label/input"));

        WebElement check3 = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div" +
                "/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/div/label/input"));

        WebDriverWait wait = new WebDriverWait(browser, 45);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form-container\"]" +
                "/div/div/div/div/div[1]/div[1]/div/span")));

        check2.click();
        check3.click();

        Assertions.assertTrue(check2.isSelected());
        Assertions.assertTrue(check3.isSelected());
    }

    @Test
    public  void testRadioBtn() {
        WebElement radio = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div" +
                "/div/div/div[2]/div[2]/div[6]/div/div[2]/div/div[2]/div/label/input"));

        WebDriverWait wait = new WebDriverWait(browser, 45);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form-container\"]" +
                "/div/div/div/div/div[1]/div[1]/div/span")));
        radio.click();
        Assertions.assertTrue(radio.isSelected());
    }

    @AfterEach
    public void finish() {
        browser.close();
    }

}
