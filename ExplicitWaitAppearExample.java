package assignments.week4.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

public class ExplicitWaitAppearExample {
	public static void main(String args[]) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/appear.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(12));
		WebElement present=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn']")));
		String textMessage=present.getText();
		System.out.println(textMessage);
		List<WebElement> buttonList=driver.findElements(By.tagName("button"));
		for (WebElement nameDisplay : buttonList) {
			System.out.println(nameDisplay.getText());
		}
		File output=driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(output, new File("C:\\TestLeaf_January_2022_Selenium\\MavenProject\\src\\test\\resources\\screenshots\\ExplicitWaitAppearExample.png"));
	}
}