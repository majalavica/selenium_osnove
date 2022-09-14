package d13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

//	Maksimizirati prozor
//	Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//	Prijavite se na sistem 
//	Username: Admin
//	Password: admin123
//	Cekanje od 5s
//	U input za pretragu iz navigacije unesite tekst Me
//	Kliknite na prvi rezultat pretrage (to ce biti Time)
//	Cekanje od 1s
//	Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//	Klinkite na logout
//	Cekanje od 5s
//	Zatvorite pretrazivac

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(500);

		driver.findElement(By.name("username")).sendKeys("Admin");;
		Thread.sleep(500);

		driver.findElement(By.name("password")).sendKeys("admin123");;
		Thread.sleep(500);

		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("Me");;
		Thread.sleep(5000);

		driver.findElement(By.className("oxd-text")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()= 'Paul Collings']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()= 'Logout']")).click();

		Thread.sleep(5000);
		driver.quit();
	}

}
