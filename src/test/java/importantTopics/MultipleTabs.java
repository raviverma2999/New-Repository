package importantTopics;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MultipleTabs {

    public static void main(String[] args) {
        
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("dom.webnotifications.enabled", false);

        System.setProperty("webdriver.gecko.driver", "F:\\\\FireFoxBrowserExe\\\\geckodriver.exe");

        FirefoxDriver driver = new FirefoxDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        // Save the current window handle
        String mainTab = driver.getWindowHandle();

        // Scroll to and click 'New Tab' button
        WebElement tabButton = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabButton);
        tabButton.click();

        // Wait a bit for the new tab to open
        try { Thread.sleep(2000); } catch (InterruptedException e) { }

        // Switch to the new tab
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowId : allWindowHandles) {
            if (!windowId.equals(mainTab)) {
                driver.switchTo().window(windowId);
                System.out.println("Switched to new tab: " + driver.getTitle());
            }
        }

        // Perform actions in new tab, if any (e.g., interact with fields or elements)

        // Now go back to main tab
        driver.switchTo().window(mainTab);

        // Trigger and handle confirm box on main tab
        driver.findElement(By.id("confirmBox")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();

        driver.quit();
    }
}
