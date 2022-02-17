package assignments.week4.day1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExplicitWaitDisappearExample {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/disapper.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		Boolean presence=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//p)[2]"), "I know you can do it! Button is disappeared!"));
		System.out.println(presence);
		String textMessage=driver.findElement(By.xpath("(//p)[2]")).getText();
		System.out.println(textMessage);
		File sourceFile=driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("C:\\TestLeaf_January_2022_Selenium\\MavenProject\\src\\test\\resources\\screenshots\\image.png"));
	}
}
