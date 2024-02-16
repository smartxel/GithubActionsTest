import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WhatsappAutoDemo {
	
	static WebDriver driver;
	int previousCountInt = 0;
	int pendingPostCount = 0;
	String previousCountString = null;


	public static void main(String[] args) throws InterruptedException {
		
				
		// TODO Auto-generated method stub
				System.setProperty("webdriver.edge.driver", "C://Users//hrish//eclipse-workspace//ChatGPTTest//driver//msedgedriver.exe");

				// Start Edge Session
				WebDriver driver = new EdgeDriver();
				EdgeOptions options = new EdgeOptions();
				//options.  ("--guest")
				
				
				
				driver.get("https://web.whatsapp.com/");
				
			//	Thread.sleep(3000);
				
				driver.manage().window().maximize();
				
				Thread.sleep(16000);
				
				driver.close();
	}

}
