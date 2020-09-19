import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillForm {
    WebDriver browser;

    public FillForm(WebDriver browser) {
        this.browser = browser;
    }

    public void fillTextField() {
        WebElement textField = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div" +
                "/div/div/div[2]/div[2]/div[3]/div/div[2]/div/div/input"));
        textField.sendKeys("Ahmad Horyzat");
    }

    public void selectCheckBox() {
        WebElement check2 = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div" +
                "/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/div/label/input"));
        check2.click();

        WebElement check3 = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div" +
                "/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/div/label/input"));
        check3.click();
    }

    public void selectRadioBtn() {
        WebElement radio = browser.findElement(By.xpath("//*[@id=\"form-container\"]/div/div" +
                "/div/div/div[2]/div[2]/div[6]/div/div[2]/div/div[2]/div/label/input"));
        radio.click();
    }

    public void fillAll() {
        fillTextField();
        selectCheckBox();
        selectRadioBtn();
    }
}
