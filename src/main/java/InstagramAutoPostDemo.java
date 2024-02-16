import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class InstagramAutoPostDemo extends DriverManager {

	@Test
	public void postFeedsOnInstagram() throws InterruptedException {

		Thread.sleep(2000);
		if (driver.getCurrentUrl().contains("newzbiz")) {
			driver.navigate().to("https://www.instagram.com/");
		}
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("newzbizpro@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//div[text()='Log in']/..")).click();
		Thread.sleep(4000);
		try {
			WebElement element = driver.findElement(By.xpath("//div[text()='Not now']"));
			if (element.isDisplayed()) {
				try {
				element.click();
				}catch(Exception e) {
					Actions action = new Actions(driver);
					action.moveToElement(element).click().build().perform();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(4000);
	}

}
