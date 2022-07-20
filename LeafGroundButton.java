package week2.daytwo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButton {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	
	driver.get("http://leafground.com/pages/Button.html");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	
	//Click button to travel home page
	driver.findElement(By.id("home")).click();
	driver.findElement(By.xpath("(//div[@class='wp-landing-categories']//img)[2]")).click();
	
	//Find position of button (x,y)
	System.out.println(driver.findElement(By.id("position")).getLocation());
	
	//Find button color
	System.out.println(driver.findElement(By.id("color")).getCssValue("background-color"));
	
	//Find the height and width
	System.out.println(driver.findElement(By.id("size")).getSize());
}
}
