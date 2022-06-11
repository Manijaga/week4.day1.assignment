package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchFrameClassRoomActivity {

	public static void main(String[] args) {

		// Launch the browser
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		// 1. Launch https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		// 2. Click on Try it
		WebElement findElement = driver.findElement(By.xpath("//div[@id='iframewrapper']/iframe"));
		driver.switchTo().frame(findElement);
		driver.findElement(By.xpath("//button[text()='Try it']")).click(); // button[text()='Try it']
		// 3. Enter your name and click on ok
		Alert alert = driver.switchTo().alert();
		String name = "Manigandan";
		alert.sendKeys(name);
		alert.accept();
		// 4. verify your name
		String text = driver.findElement(By.xpath("//button[text()='Try it']/following::p")).getText();
		String[] ArryText = text.split(" ");
		if (ArryText[1].contains(name)) {
			System.out.println("The entered name is " + name + " matching with applicaiton");
		}
	}

}
