package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");

		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// 4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

		// 5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//td[@class='dijitReset dijitStretch dijitComboBoxInput']/input"))
		.sendKeys("babu ");
		Thread.sleep(3000);

		// 8. Click on First Resulting Contact
		driver.findElement(By.xpath("//div[@class='dijitMenu']/div[2]")).click();

		// 9. Click on Widget of To Contact
		driver.findElement(By.id("ComboBox_partyIdTo")).sendKeys("Vignesh ");
		Thread.sleep(3000);

		// 10. Click on Second Resulting Contact
		driver.findElement(By.xpath("//div[@class='dijitMenu']/div[3]")).click();

		// 11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		// 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// 13. Verify the title of the page
		if (driver.getTitle().equals("View Contact | opentaps CRM")) {
			System.out.println("The Contact are Merged successfully");
		} else {
			System.out.println("The Contact are not Merged");
		}

	}

}
