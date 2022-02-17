package assignments.week4.day1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTextChange {
	public static void main(String args[]) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click ME!']"))).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(4));
		Alert presence=wait1.until(ExpectedConditions.alertIsPresent());
		System.out.println(presence.getText());
		presence.accept();
		File sourceFile=driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("C:\\TestLeaf_January_2022_Selenium\\MavenProject\\src\\test\\resources\\screenshots\\ExplicitWaitTextChange.png"));
	}
}