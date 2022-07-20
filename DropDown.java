package week2.daytwo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.tools.javac.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	
	driver.get("http://www.leafground.com/pages/Dropdown.html");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	
	//Find the first dropdown and convert to Select class
	WebElement dropdown1  = driver.findElement(By.id("dropdown1"));
	Select select1 = new Select(dropdown1);
	select1.selectByIndex(1);
	
	WebElement dropdown2  = driver.findElement(By.name("dropdown2"));
	Select select2 = new Select(dropdown2);
	select2.selectByVisibleText("Selenium");
	
	WebElement dropdown3  = driver.findElement(By.id("dropdown3"));
	Select select3 = new Select(dropdown3);
	select3.selectByValue("1");
	
	Select dropDown = new Select(driver.findElement(By.xpath("(//div[@id='contentblock']//div[4])//select")));
	java.util.List<WebElement> elementCount = dropDown.getOptions();
	System.out.println("Number of items: " + elementCount.size());
	
	
	driver.findElement(By.xpath("(//div[@id='contentblock']//div[5])//select")).sendKeys("Selenium");
	driver.findElement(By.xpath("(//div[@id='contentblock']//div[6])//select")).sendKeys("Selenium");
}
}
