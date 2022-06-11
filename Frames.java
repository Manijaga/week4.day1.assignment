package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	public static void main(String[] args) throws InterruptedException {
		// Launch the browser
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		// Open frame link
		driver.get("http://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.manage().window().maximize();
		// Fill the Topic text box
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Selenium Java");
		// check the check box
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		// select animal name
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		Select frameValue = new Select(driver.findElement(By.id("animals")));
		frameValue.selectByVisibleText("Baby Cat");
	}
}
