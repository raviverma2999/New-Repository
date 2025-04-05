package importantTopics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateSelection {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "F:\\\\FireFoxBrowserExe\\\\geckodriver.exe");

		 FirefoxProfile profile = new FirefoxProfile();

	        // Disable browser notification popups
	        profile.setPreference("dom.webnotifications.enabled", false);
	        profile.setPreference("permissions.default.desktop-notification", 2); // 2 = Block

	        // Apply profile to FirefoxOptions
	        FirefoxOptions options = new FirefoxOptions();
	        options.setProfile(profile);

	        // Launch browser with custom options
	        FirefoxDriver driver = new FirefoxDriver(options);

		driver.get("https://demoqa.com/date-picker");

		driver.manage().window().maximize();
		
		driver.findElement(By.id("datePickerMonthYearInput")).click();
		
		WebElement selectMonth=driver.findElement(By.className("react-datepicker__month-select"));
		
		Select select=new Select(selectMonth);
		
		select.selectByVisibleText("July");
		
		WebElement selectYear=driver.findElement(By.className("react-datepicker__year-select"));
		
        Select select1=new Select(selectYear);
		
        select1.selectByVisibleText("2030");
        
        driver.findElement(By.xpath("//div[@aria-label=\"Choose Thursday, July 25th, 2030\"]")).click();
		
		
	}
}
