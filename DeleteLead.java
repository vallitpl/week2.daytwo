package week2.daytwo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");//Find the password field and enter the password (crmsfa)
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click the login button
		driver.findElement(By.className("decorativeSubmit")).click();

		//Finally we need to check whether we are in correct page
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		String attribute =logout.getAttribute("value");
		System.out.println(attribute);
		if(attribute.equals("LOGOUT"))
		{
			System.out.println("Successfully logged IN");
		}
		
		//click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();

		//click Leads tab
		driver.findElement(By.linkText("Leads")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Click on Phone
		driver.findElement(By.linkText("Phone")).click();
		
		//Enter phone number
		driver.findElement(By.id("ext-gen270")).sendKeys("98765");
		
		//Click find leads button
		driver.findElement(By.id("ext-gen334")).click();		
		Thread.sleep(2000);
		
		//Capture lead ID of First Resulting lead
		WebElement string = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]"));
		String strText = string.getText();
		System.out.println(strText);
		
		//Click First Resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
		
		//Click Delete
		driver.findElement(By.linkText("Delete")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(strText);
		
		//Click find leads button
		driver.findElement(By.id("ext-gen334")).click();
		Thread.sleep(3000);
		
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement checkRecords = driver.findElement(By.xpath("(//div[@class='x-panel-bbar']//div//div)"));
		String records = checkRecords.getText();
		//System.out.println(records);
		
		if (records.contains("No records to display"))
		{
			System.out.println("No records to display");
		}
		else
		{
			System.out.println("There are still some records");
		}
		
		//Close the browser (Do not log out)
		driver.close();
	}
	
		
	
}
