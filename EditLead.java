package week2.daytwo;

import java.time.Duration;
import java.time.temporal.TemporalAmount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	
	driver.findElement(By.linkText("Leads")).click();
	
	//Click Find leads
	driver.findElement(By.linkText("Find Leads")).click();
	
	//Enter first name
	driver.findElement(By.id("ext-gen248")).sendKeys("Valli");
	
	//Click Find leads button
	driver.findElement(By.id("ext-gen334")).click();
	System.out.println("Clicked Find Leads");
	
	Thread.sleep(2000);
	
	//Click on first resulting lead
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
	System.out.println("Clicked 10972");
	
	Thread.sleep(2000);
	//Verify title of the page
	String title = driver.getTitle();
	if(title.equalsIgnoreCase("View Lead | opentaps CRM"))
	{
		System.out.println("Verified Title");
	}
	else
	{
		System.out.println("Title not verified");
	}
	
	Thread.sleep(2000);
	// Click Edit
	driver.findElement(By.linkText("Edit")).click();
	System.out.println("Clicked Edit");
	
	//Change the company name
	driver.findElement(By.id("updateLeadForm_companyName")).clear();
	System.out.println("Cleared company name");
	driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("New Company");
	System.out.println("New company name");
	
	//Click Update
	driver.findElement(By.name("submitButton")).click();
	System.out.println("finally submitted");
	
	Thread.sleep(2000);
	
	// Confirm the changed name appears
	WebElement compare = driver.findElement(By.id("viewLead_companyName_sp"));
	String strText =  compare.getText();
	System.out.println(strText);
	if (strText.contains("New Company"))
	{
		System.out.println("The new name exists");
	}
	else
	{
		System.out.println("The new name does not exists");
	}
		
	//Close the browser (Do not log out)
	driver.close();
}
}
