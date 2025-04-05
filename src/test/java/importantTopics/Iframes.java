package importantTopics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Iframes {

    public static void main(String[] args) {
        
        System.setProperty("webdriver.gecko.driver", "F:\\\\FireFoxBrowserExe\\\\geckodriver.exe");
        
        WebDriver driver = new FirefoxDriver();
        
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Frame 1
        driver.switchTo().frame(0);
        driver.findElement(By.name("mytext1")).sendKeys("mytext1");
        System.out.println("Frame 1 title: " + driver.getTitle());
        driver.switchTo().defaultContent();

        // Frame 2
        driver.switchTo().frame(1);
        driver.findElement(By.name("mytext2")).sendKeys("This is frame 2");
        System.out.println("Frame 2 title: " + driver.getTitle());
        driver.switchTo().defaultContent();

        // Frame 3
        driver.switchTo().frame(2);
        driver.findElement(By.name("mytext3")).sendKeys("This is frame 3");
        System.out.println("Frame 3 title: " + driver.getTitle());
        driver.switchTo().defaultContent();

        // Frame 4 (nested frame)
        driver.switchTo().frame(3); // outer frame
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        driver.switchTo().frame("center"); // inner nested frame
        
        WebElement captchaBox = driver.findElement(By.xpath("//div[@class='vd3tt']//div[contains(text(),'I am a human')]"));

        if (captchaBox.isDisplayed()) {
            captchaBox.click();
            System.out.println("Clicked on CAPTCHA box");
        } else {
            System.out.println("CAPTCHA element not visible");
        }

        driver.findElement(By.xpath("(//div[@class=\"vd3tt\"]/child::div)[1]")).click();
        System.out.println("Frame 4 (nested) title: " + driver.getTitle());
        
       
    }
}
