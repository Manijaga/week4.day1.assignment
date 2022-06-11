package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSwitchWindow {
	public static void main(String[] args) {

		// Launch the browser
		WebDriverManager.edgedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		// Accept the alert by clicking on ok
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		// 3. Click on Flights

		driver.findElement(By.xpath("//a[@aria-label='Flight opens a new window']")).click();
		// 4. Switch to new window

		Set<String> windowHandels = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandels);
		driver.switchTo().window(windows.get(1));
		// 5. get title 6. close current window
		System.out.println("The Web page title is - " + driver.getTitle());
		driver.close();

	}

}
