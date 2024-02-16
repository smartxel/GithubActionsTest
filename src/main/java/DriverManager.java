import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverManager {
	static WebDriver driver;
	int previousCountInt = 0;
	int pendingPostCount = 0;
	String previousCountString = null;

	@BeforeClass
	public void initiateDriver() throws InterruptedException {
		
				
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		
		driver = new ChromeDriver(options);

		driver.get("https://www.newzbiz.com/wp-login.php?");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Log in with username and password')]")).click();
		driver.findElement(By.id("user_login")).sendKeys("shyams");
		driver.findElement(By.id("user_pass")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[text()='Posts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='publish']/a")).click();

		String postCount = driver.findElement(By.xpath("//li[@class='publish']//span")).getText();
		postCount = postCount.substring(1, postCount.length() - 1);
		// System.out.println(postCount);
		int postCountInt = Integer.parseInt(postCount);

		System.out.println("postCountInt :: " + postCountInt);

		try {
			previousCountInt = Integer.parseInt(readPreviousPostCount());
			System.out.println("previousCountInt :: " + previousCountInt);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (postCountInt != previousCountInt) {
			System.out.println("postCountInt " + postCountInt);
			System.out.println("previousCountInt " + previousCountInt);
			pendingPostCount = postCountInt - previousCountInt;
			System.out.println("pendingPostCount :: " + pendingPostCount);
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//tbody[@id='the-list']//tr[1]")));
			actions.perform();

			List<WebElement> ele = driver.findElements(By.xpath("//tbody[@id='the-list']//tr//span[@class='view']/a"));
			List<String> list = new ArrayList<String>();

			for (int i = 0; i < pendingPostCount; i++) {

				String postURL = ele.get(i).getAttribute("href");
				list.add(postURL);
				DataStorage.setMap("newzbiz.updated.posts", list);

			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println("urls: " + list.get(i));
			}

		} else {
			driver.close();
		}
	}

	public static String readPreviousPostCount() {
		String previousPostCount = null;
		try {
			File myObj = new File("D:\\testdatafornewzbiz.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				previousPostCount = myReader.nextLine();
				// System.out.println(previousPostCount);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return previousPostCount;
	}

	public static boolean loginToLiknedIN() throws InterruptedException {

		boolean status = false;

		driver.navigate().to("https://www.linkedin.com");
		driver.manage().window().maximize();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("nimbprashant@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("20august2017");
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		Thread.sleep(4000);
		if (driver.findElement(By.xpath("//button//span[text()='Start a post']")).isDisplayed()) {
			status = true;
		}
		return status;
	}

	@AfterClass
	public void closeDriver() throws InterruptedException {

		driver.navigate().to("https://www.newzbiz.com/wp-admin/edit.php?post_status=publish&post_type=post");
		Thread.sleep(4000);
		String previousPostCount = driver.findElement(By.xpath("//li[@class='publish']//span")).getText();
		previousPostCount = previousPostCount.substring(1, previousPostCount.length() - 1);
		System.out.println(previousPostCount);

		previousCountInt = Integer.parseInt(previousPostCount);
		try {

			// Create a FileWriter object
			// to write in the file
			File file = new File("newzbiztestdata");
			String path = file.getAbsolutePath();
			System.out.println("path" + path);
			// FileWriter fWriter = new FileWriter(path+".txt");

			FileWriter fWriter = new FileWriter("D:\\testdatafornewzbiz.txt");

			// Writing into file
			// Note: The content taken above inside the
			// string
			previousCountString = String.valueOf(previousCountInt);

			fWriter.write(previousCountString);

			// Printing the contents of a file
			System.out.println(previousCountInt);

			// Closing the file writing connection
			fWriter.close();

			// Display message for successful execution of
			// program on the console
			System.out.println("File is created successfully with the content.");

		} catch (IOException e) {

			// Print the exception
			System.out.print(e.getMessage());
		}

		if (!driver.equals(null)) {
			driver.close();
		}
	}

}
