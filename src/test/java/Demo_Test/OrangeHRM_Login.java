package Demo_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class OrangeHRM_Login {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=\" Login \"]")).click();

        System.out.println(driver.findElement(By.xpath("//div[@class=\"oxd-sidepanel-body\"]")).getText());

        driver.close();

    }
}
