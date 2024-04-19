package Demo_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Eckhotrack_WithTestNG {

    WebDriver driver;
    @BeforeMethod
    public void beforemethod(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
    }

    @Test
    public void dofollowingTasks(){

        driver.findElement(By.xpath("//input[@id=\"txtCustomerID\"]")).sendKeys("dfsd");  //enter invalid email
        driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("sfs"); //enter invalid password
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click(); //click on login


    }
    @AfterMethod
    public void aftermethod(){
        System.out.println(driver.findElement(By.xpath("//span[@id=\"lblMsg\"]")).getText()); // print the output message

        driver.close();
    }
}
