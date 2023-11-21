package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl ="https://www.saucedemo.com/";
    @Before
    public void openBrowser() throws InterruptedException{
        broswerSetUp(baseUrl);
    }
    @Test
    public void userShouldLogininSuccessfullyWithValidCredentials() throws InterruptedException{
        //input user name by.xpath
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        Thread.sleep(2000);
        //input password using by.id
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.name("login-button")).click();
        Thread.sleep(2500);

        //verify after login you can see products
        String expected = "Products";
        WebElement actualclick = driver.findElement(By.xpath("//*[contains(@class,'title')]"));
        String Actual = actualclick.getText();
        Assert.assertEquals(expected,Actual);
    }
    @Test

    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException{
        //input user name by.id
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        Thread.sleep(1000);
        //input password using by.xpath
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.name("login-button")).click();
        Thread.sleep(2500);
        // verify six products on the page after log in
        List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        int actual = products.size();
        System.out.println(actual);
        int expected = 6;
        Assert.assertEquals("Correct Amount not Displayed",expected,actual);
        Thread.sleep(3000);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
