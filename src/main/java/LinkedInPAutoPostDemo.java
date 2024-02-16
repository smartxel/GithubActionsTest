import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LinkedInPAutoPostDemo extends DriverManager {

	@Test
	public void postToTwitter() throws InterruptedException {

		if (driver.getCurrentUrl().contains("newzbiz")) {
			driver.navigate().to("https://www.linkedin.com");
		}

		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("nimbprashant@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("20august2017");
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button//span[text()='Start a post']")).click();
		Thread.sleep(4000);

		Set<String> windows = driver.getWindowHandles();

		for (String string : windows) {
			System.out.println("" + string);
		}

		WebElement ele = driver.findElement(By.xpath("//div[@aria-placeholder='What do you want to talk about?']/p"));
		ele.click();

		for (Map.Entry<String, List<String>> entry : DataStorage.getMap().entrySet()) {
			if (entry.getKey().equals("newzbiz.updated.posts")) {
				
				for (String listValue : entry.getValue()) {
					System.out.println("List Value :: "+listValue);
					ele.sendKeys(listValue);
				}
			}
		}

		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button/span[text()='Post']")).click();
		Thread.sleep(4000);

	}

}
