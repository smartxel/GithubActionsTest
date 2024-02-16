import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TwitterAutoPostDemo extends BrowserstackDriverManager {

	@Test
	public void twitterPost() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("I am here in twitter class");
		System.out.println("current URL :: " + driver.getCurrentUrl());
		Thread.sleep(2000);
		if (driver.getCurrentUrl().contains("newzbiz")) {
			driver.navigate().to("https://twitter.com/");
		}
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@autocomplete='username']")).click();
		driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("newzbizpro@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']/../..")).click();
		Thread.sleep(2000);
		try {
			WebElement element = driver
					.findElement(By.xpath("//span[text()='Phone or username']/../../following-sibling::div//input"));
			if (element.isEnabled()) {
				element.click();
				element.sendKeys("@NewzBizMedia");
				driver.findElement(By.xpath("//span[text()='Next']/../..")).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Password']/../../following-sibling::div//input")).click();
		driver.findElement(By.xpath("//span[text()='Password']/../../following-sibling::div//input"))
				.sendKeys("Welcome@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Log in']/../..")).click();
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//div[text()='What is happening?!']/../following-sibling::div/div")).click();

		for (Map.Entry<String, List<String>> entry : DataStorage.getMap().entrySet()) {
			if (entry.getKey().equals("newzbiz.updated.posts")) {

				for (String listValue : entry.getValue()) {
					System.out.println("List Value :: " + listValue);
					driver.findElement(By.xpath("//div[text()='What is happening?!']/../following-sibling::div/div"))
					.click();
					driver.findElement(By.xpath("//div[text()='What is happening?!']/../following-sibling::div/div"))
							.clear();
					
					driver.findElement(By.xpath("//div[text()='What is happening?!']/../following-sibling::div/div"))
							.sendKeys(listValue);

					Thread.sleep(4000);
					driver.findElement(By.xpath("//span[text()='Post']/../..")).click();
					Thread.sleep(2000);
				}
			}
		}

	}

}
