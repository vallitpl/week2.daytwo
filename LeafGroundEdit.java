package week2.daytwo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Edit.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Enter your email address
		driver.findElement(By.id("email")).sendKeys("abcd.efgh@gmail.com");
		
		//Append a text and press keyboard tab
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']//input)[2]")).sendKeys("string");
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']//input)[2]")).sendKeys(Keys.TAB);
		
		//Get default text Entered
		/*WebElement value = driver.findElement(By.name("username"));
		String value1 = getAttribute(value);
		System.out.println(value1);*/
		
		 System.out.println(driver.findElement(By.name("username")).getAttribute("value"));
		
		//Clear the text
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']//input)[4]")).clear();
		
		//confirm that edit field is disabled
		System.out.println(driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']//input)[5]")).isEnabled());
		
	}



}
