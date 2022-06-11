package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) throws InterruptedException {
		// Launch the browser
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		// Open testleaf page
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// 1. Click button to open home page in New Window
		driver.findElement(By.id("home")).click();
		// Close the New window
		Set<String> windowhandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowhandles);
		driver.switchTo().window(window.get(1));
		driver.close();
		// Back to parent window
		driver.switchTo().window(window.get(0));

		// 2. Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		// Find windows count
		Set<String> windowhandlesOne = driver.getWindowHandles();
		List<String> windowOne = new ArrayList<String>(windowhandlesOne);
		System.out.println("The Total Number of Windows is - " + windowOne.size());

		// 3. Close all except this window
		for (int i = 1; i < windowhandlesOne.size(); i++) {
			driver.switchTo().window(windowOne.get(i));
			driver.close();
		}
		// Back to parent window
		driver.switchTo().window(windowOne.get(0));

		// 4. Wait for 2 new Windows to open
		driver.findElement(By.id("color")).click();
		Thread.sleep(5000);
		// or //wait until the browser count is 3
		do {
			break;
		} while ((driver.getWindowHandles().size()) == 3);
		
		driver.quit();

	}

}
