/**
 * automation for saucedemo.com create basetest class and logintest class
 * also check credential before login and after login
 */

package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    static String browser="chrome";
    public static WebDriver driver;
    static String baseUrl = "https://www.saucedemo.com/";

    public void broswerSetUp(String baseUrl) throws InterruptedException{
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Thread.sleep(2000);
    }
public void closeBrowser(){
        driver.quit();
}
}
