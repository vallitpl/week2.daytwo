package week2.daytwo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	
	driver.get("https://en-gb.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//Click on Create New Account button
	driver.findElement(By.xpath ("//a[contains(text(),'Create New Account')]")).click();	
	
	// Step 7: Enter the first name
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Valli");
	
	// Step 8: Enter the last name
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("tpl");
	
	// Step 9: Enter the mobile number
	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("vallitpl@gmail.com");
			
	// Step 10: Enter the password
	driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("July@2022");
	
	// Step 11: Handle all the three drop downs
	WebElement day = driver.findElement(By.id("day"));
	Select selectDay = new Select(day);
	selectDay.selectByVisibleText("10");
	
	WebElement month = driver.findElement(By.id("month"));
	Select selectMonth = new Select(month);
	selectMonth.selectByVisibleText("Oct");
	
	WebElement year = driver.findElement(By.id("year"));
	Select selectYear = new Select(year);
	selectYear.selectByVisibleText("1986");	
	
	// Step 12: Select the radio button "Female" 
	driver.findElement(By.xpath("//label[text()='Female']")).click();

}
}
