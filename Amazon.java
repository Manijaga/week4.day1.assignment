package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.edge.EdgeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Launch the browser
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		// Open the amazon link
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Search as OnePlue 9 Pro
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("OnePlue 9 Pro", Keys.ENTER);

		// Get the price of the first product
		String fistProductAmout = driver
				.findElement(By.xpath("//div[@class='a-row a-size-base a-color-base']/a/span/span[2]/span[2]"))
				.getText();
		System.out.println("The Price of the First Product Is - " + fistProductAmout);

		// Print the number of customer rating for the first displayed product
			System.out.println("The Product Rating Is - " + driver.findElement(By.xpath(
				"//span[text()='RESULTS']/following::span[contains(@aria-label,'out of 5 stars')]"))
				.getAttribute("aria-label"));

		// click the fist text link of the first image
		driver.findElement(By.xpath("//span[text()='RESULTS']/following::a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();

		// take a screen shot of the product displayed
		Set<String> windowHandels = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandels);
		driver.switchTo().window(windows.get(1));
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Product.png");
		FileUtils.copyFile(screenshotAs, destination);

		// Click "add to Card" button
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(4000);
		// Get the card sub total and verify if it is correct
		String verifyFistProductAmout = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		
		//System.out.println(verifyFistProductAmout);
		
		if (verifyFistProductAmout.contains(fistProductAmout)) {
			System.out.println("Product Amount is matching" + verifyFistProductAmout );
		} else {
			{
				System.out.println("Product Amount is not matching");
			}
			// close the browser

		}
	}

}
