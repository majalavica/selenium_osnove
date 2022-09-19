package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
//		Napisati program koji 
//		Ucitava https://seeds.sproutsocial.com/components/loader-button/
//		Odskrola do Loader buttons are used to display a loading indicator inside of a button. paragrafa. Koristan link
//		Klikce ne dugme 
//		Ceka da dugme zavrsi sa loadingom 
//		Ispisati poruku na ekranu
//		Zatvoriti pretrazivac
//		HINT: Koristite data-qa-button-isloading  atribut elementa za cekanje odredjenog stanja tog elementa

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get("https://seeds.sproutsocial.com/components/loader-button/");
		Thread.sleep(1000);

		// false, nije kliknuto
		String isClicked = driver.findElement(By.xpath("//*[contains(@class, 'gqbpqF')]/button"))
				.getAttribute("data-qa-button-isloading");
		System.out.println(isClicked);

		
		// true, kliknuto je
		new Actions(driver)
		.moveToElement(driver.findElement(By.xpath("//*[contains(@class, 'gqbpqF')]/button")))
		.click()
		.perform();
		Thread.sleep(500);


		isClicked = driver.findElement(By.xpath("//*[contains(@class, 'gqbpqF')]/button"))
				.getAttribute("data-qa-button-isloading");
		System.out.println(isClicked);

		

		Thread.sleep(5000);
		driver.quit();
	}

}
