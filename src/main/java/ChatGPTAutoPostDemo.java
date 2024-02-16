import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ChatGPTAutoPostDemo extends ChatGPTDriverManager {

	@Test
	public void postToChatGPT() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//div[text()='Log in']/..")).click();
		Thread.sleep(8000);
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;	
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='content']")));
		//	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(8000);
	}

}
