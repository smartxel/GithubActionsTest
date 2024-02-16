import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ChatGPTDriverManager {
	
	static WebDriver driver;
	@BeforeTest
	public void instatiateDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hrish\\eclipse-workspace\\AutoPostDemo\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		
		
		driver = new ChromeDriver(options);

		driver.get("https://chat.openai.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void closeDriver() {
		
	}

}
