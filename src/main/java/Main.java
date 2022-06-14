import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static ChromeDriver driver;
    public static void main(String[]  args) throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\files2\\chromedriver.exe");
       new MainWindows();

    }
    public static void openBrowser() throws InterruptedException {
        boolean isConnected= false;
        System.setProperty("webdriver.chrome.driver","C:\\files2\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver=new ChromeDriver(options);

        options.addArguments("--start-maximized");
        driver.get("https://web.whatsapp.com/");
        Thread.sleep(3000);


    }

    public static void sendMessage(LinkedList<Contacts> contactsList, String msg) throws Exception{


        System.setProperty("webdriver.chrome.driver","C:\\files2\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir=C:\\Users\\tzirkus\\AppData\\Local\\Google\\Chrome\\User Data");
//        ChromeDriver driver = new ChromeDriver(options);
//        options.addArguments("--start-maximized");
//        driver.get("https://web.whatsapp.com/");

        for(Contacts x: contactsList){

            try {
                driver.navigate().to("https://web.whatsapp.com/send?phone=972"+x.getNumber().substring(1)+"&text&app_absent=0");
                //        driver.get("https://web.whatsapp.com/send?phone=972"+phone.substring(1)+"&text="+msg+"&app_absent=0");
//            driver.get("https://web.whatsapp.com/send?phone=972"+x.getNumber().substring(1)+"&text&app_absent=0");
                Thread.sleep(4000);
                WebElement messageText = driver.findElement(By.xpath("//div[@id='main']/footer/div/div/span[2]/div/div[2]/div/div/div[2]"));
                messageText.sendKeys("היי "+x.getName()+" "+msg);

//        WebElement element = driver.findElement(By.xpath("//div[@title='הקלדת ההודעה']"));
//        element.sendKeys("ffff");



                WebElement button = driver.findElement(By.xpath("//span[@data-testid=\"send\"]"));
                button.click();
                Thread.sleep(3000);
                continue;
//       driver.findElement(By.id("send")).click();

            }catch (Exception e) {
//                failed.add(new Contacts(x));
                continue;
            }




        }



//        Thread.sleep(10000);
//        driver.quit();


//        System.out.println("Done "+(contacts.size()-failed.size())+"/"+contacts.size());
//        System.out.println("failed list");
//        System.out.println(failed.toString());

    }

}
