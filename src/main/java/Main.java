import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[]  args) throws Exception{
        // test for Yuda(:
        Scanner scanner= new Scanner(System.in);
        String phone, msg;
//        System.out.println("Enter the number");
//        phone= scanner.next();
//        scanner.nextLine();
        System.out.println("Enter the message");
        msg= scanner.nextLine();
        LinkedList<Contacts> contacts=new LinkedList<Contacts>();
        contacts.add(new Contacts("0586609770","ישי"));
        contacts.add(new Contacts("0538203770","יוסי"));

        System.setProperty("webdriver.chrome.driver","C:\\files\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\tzirkus\\AppData\\Local\\Google\\Chrome\\User Data");
        ChromeDriver driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get("https://web.whatsapp.com/");

        for(Contacts x: contacts){
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
//       driver.findElement(By.id("send")).click();

        }



        Thread.sleep(5000);
        driver.quit();





    }
}
