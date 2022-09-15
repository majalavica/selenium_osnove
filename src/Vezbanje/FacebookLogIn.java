package Vezbanje;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogIn {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(500);

		driver.get("https://www.facebook.com/");
		Thread.sleep(500);

		Scanner s = new Scanner(System.in);

		System.out.println("Enter your E-mail: ");
		String username = s.next();

		driver.findElement(By.id("email")).sendKeys(username);
		Thread.sleep(500);

		System.out.println("Enter your password: ");
		String password = s.next();

		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(1000);

		driver.findElement(By.className("_9lsb")).click();// This reveal your password, to make sure you've entered the
															// correct one
		Thread.sleep(4000);

//		driver.findElement(By.name("login")).click();
		driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);
		driver.quit();
	}

}
