package week2.daytwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTable {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	Actions act = new Actions(driver);
	driver.get("https://www.zoomcar.com/in/bangalore/");
	
	//Manage Timeout
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();	
	
	//Click on Pickup City 
	driver.findElement(By.className ("placeholder")).click();
	
	//Click the first suggested pick up location 
	driver.findElement(By.className ("ellipsis")).click();
	
	//Click on Calender date
	driver.findElement(By.className ("field-date")).click();
	
	//Click on Date 20 (twice)	
	
	WebElement ele = driver.findElement(By.xpath ("//td[contains(text(),'22')]"));
	act.doubleClick(ele).perform();
	//driver.findElement(By.xpath ("//td[contains(text(),'22')]")).click();
	//driver.findElement(By.xpath ("//td[contains(text(),'22')]")).click();
			
	//Click Continue
	boolean flag = false;
	flag = driver.findElement(By.xpath ("//button[contains(text(),'Continue')]")).isEnabled();
	System.out.println(flag);
	driver.findElement(By.xpath ("//button[contains(text(),'Continue')]")).click();
	
	//Click Find Cars
	driver.findElement(By.xpath("//button[contains(text(),'Find cars')]")).click();

	//Find the price of maruti swift dzire 
	String price = driver.findElement(By.xpath("(//h3[text()='Maruti Swift Dzire']/following::div[@class='price-book-ctr']/div/div)[1]")).getText();
	System.out.println(price);
	
	
} 
}
