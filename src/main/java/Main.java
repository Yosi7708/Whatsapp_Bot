import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[]  args) throws Exception{
       new MainWindows();

    }
    public static void sendMessage(LinkedList<Contacts> contactsList, String msg) throws Exception{
//        Scanner scanner= new Scanner(System.in);
//        String phone, msg;
////        System.out.println("Enter the number");
////        phone= scanner.next();
////        scanner.nextLine();
//        System.out.println("Enter the message");
//        msg= scanner.nextLine();
//        LinkedList<Contacts> contacts=new LinkedList<Contacts>();
//        LinkedList<Contacts> failed=new LinkedList<Contacts>();
//        contacts.add(new Contacts("0586609770","ישי"));
//        contacts.add(new Contacts("057555","דוד"));
//        contacts.add(new Contacts("0587","דוד"));
//        contacts.add(new Contacts("057","דוד"));
//        contacts.add(new Contacts("0538203770","יוסי"));

        System.setProperty("webdriver.chrome.driver","C:\\files2\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\tzirkus\\AppData\\Local\\Google\\Chrome\\User Data");
        ChromeDriver driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get("https://web.whatsapp.com/");

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



        Thread.sleep(2000);
        driver.quit();


//        System.out.println("Done "+(contacts.size()-failed.size())+"/"+contacts.size());
//        System.out.println("failed list");
//        System.out.println(failed.toString());

    }

}
