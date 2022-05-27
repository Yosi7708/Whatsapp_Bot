import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestYakov {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\files\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\tzirkus\\AppData\\Local\\Google\\Chrome\\User Data");
        ChromeDriver driver = new ChromeDriver(options);
        NumberToSendWhatsapp test=new NumberToSendWhatsapp(586010301,972);
        driver.navigate().to(test.getUrlToSend());
        Thread.sleep(4000);
        WebElement messageText = driver.findElement(By.xpath("//div[@id='main']/footer/div/div/span[2]/div/div[2]/div/div/div[2]"));
        messageText.sendKeys("היי ");
        WebElement button = driver.findElement(By.xpath("//span[@data-testid=\"send\"]"));
        button.click();
    }
}