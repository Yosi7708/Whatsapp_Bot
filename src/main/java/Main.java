import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static boolean isConnected=false;
    public static boolean isSent=false;

    static ChromeDriver driver; // for test
    public static LinkedList<Contacts> failed = new LinkedList<Contacts>();

    public static void main(String[]  args) throws Exception{
        System.setProperty("webdriver.chrome.driver" , "C:\\DriverForGame\\chromedriver.exe");

        new MainWindows();

    }
    public static void checkIfConnected() {
        while (!isConnected) {
            try {
                driver.findElement(By.className("_3aF8K"));
                isConnected = false;
            } catch (Exception e) {
                isConnected = true;
            }
        }
    }
    public static void openBrowser() throws InterruptedException {
        boolean isConnected= false;
        System.setProperty("webdriver.chrome.driver" , "C:\\DriverForGame\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver=new ChromeDriver(options);

        options.addArguments("--start-maximized");
        driver.get("https://web.whatsapp.com/");
        Thread.sleep(3000);

    }
    public static void sendMessage(LinkedList<Contacts> contactsList, String msg) throws Exception{


        System.setProperty("webdriver.chrome.driver" , "C:\\DriverForGame\\chromedriver.exe");
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
                Thread.sleep(6000);
                WebElement messageText = driver.findElement(By.className("_1LbR4")).findElement(By.className("_13NKt"));

                messageText.sendKeys("היי "+x.getName()+" "+msg, Keys.ENTER);
                x.setSent(true);
//                WebElement button = driver.findElement(By.xpath("//span[@data-testid=\"send\"]"));
//                button.click();
                Thread.sleep(3000);
                continue;
//              driver.findElement(By.id("send")).click();

            }catch (Exception e) {
                failed.add(new Contacts(x));
                continue;
            }
        }
//        Thread.sleep(10000);
//        driver.quit();


//        System.out.println("Done "+(contacts.size()-failed.size())+"/"+contacts.size());
//        System.out.println("failed list");
//        System.out.println(failed.toString());
           //isSent=true;


    }
//    public static void print(){
//        System.out.println(report());
//    }
//    public static String report(){
//        String report ="the message was sent to";
//        return report+ (addContacsWindow.contactsList.size()-failed.size());
//    }

}
