package week2.daytwo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	
	driver.get("http://leafground.com/pages/checkbox.html");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	
	//Select the languages that you know?
	driver.findElement(By.xpath("(//div[@id='contentblock']//div//input)[1]")).click();
	driver.findElement(By.xpath("(//div[@id='contentblock']//div//input)[3]")).click();
	
	//Confirm Selenium is checked
	System.out.println(driver.findElement(By.xpath("(//div[@id='contentblock']//div[2]//input)")).isSelected());
		
	//DeSelect only checked
	Boolean checkIfSelected = driver.findElement(By.xpath("(//div[@id='contentblock']//div[3]//input)[1]")).isSelected();
	if (checkIfSelected.equals (true))
	{
		driver.findElement(By.xpath("(//div[@id='contentblock']//div[3]//input)[1]")).click();
	}
	Boolean checkIfSelected1 = driver.findElement(By.xpath("(//div[@id='contentblock']//div[3]//input)[2]")).isSelected();
	if (checkIfSelected1.equals (true))
	{
		driver.findElement(By.xpath("(//div[@id='contentblock']//div[3]//input)[2]")).click();
	}
	//Select all below checkboxes
	driver.findElement(By.xpath("(//div[@id='contentblock']//div[4]//input)[1]")).click();
	driver.findElement(By.xpath("(//div[@id='contentblock']//div[4]//input)[2]")).click();
	driver.findElement(By.xpath("(//div[@id='contentblock']//div[4]//input)[3]")).click();
	driver.findElement(By.xpath("(//div[@id='contentblock']//div[4]//input)[4]")).click();
	driver.findElement(By.xpath("(//div[@id='contentblock']//div[4]//input)[5]")).click();
	driver.findElement(By.xpath("(//div[@id='contentblock']//div[4]//input)[6]")).click();
}
}
