import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FacebookAutoPostDemo extends DriverManager {

	@Test
	public void postUpdatedNewsToFacebook() throws InterruptedException {

		Thread.sleep(2000);
		if (driver.getCurrentUrl().contains("newzbiz")) {
			driver.navigate().to("https://www.facebook.com/");
		}
		Thread.sleep(4000);
		driver.findElement(By.id("email")).sendKeys("newzbizpro@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[text()='Shyam Singh']/..")).click();
		Thread.sleep(4000);

		for (Map.Entry<String, List<String>> entry : DataStorage.getMap().entrySet()) {
			if (entry.getKey().equals("newzbiz.updated.posts")) {

				for (String listValue : entry.getValue()) {
					System.out.println("List Value :: " + listValue);
					Actions actions = new Actions(driver);
					actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'on your mind?')]")));
					actions.perform();
					// driver.findElement(By.xpath("//span[contains(text(),'on your
					// mind?')]")).sendKeys(listValue);
					driver.findElement(By.xpath("//span[contains(text(),'on your mind?')]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[contains(text(),'on your mind?')]/preceding-sibling::div/p"))
							.click();
					driver.findElement(By.xpath("//div[contains(text(),'on your mind?')]/preceding-sibling::div/p"))
							.sendKeys(listValue);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//span[text()='Post']/../../../..")).click();
					Thread.sleep(8000);
				}
			}
		}

	}

}
