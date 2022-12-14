package d13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
//		Napisati program koji vrsi dodavanje 5 reda u tabelu. 
//		Maksimizirati prozor
//		Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//		Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji 
//		Klik na dugme Add New
//		Unesite name,departmant i phone (uvek iste vrednost)
//		Trazenje po name atributu
//		Kliknite na zeleno Add dugme. 
//		PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add, 
//		delete ali zbog prirode reda neki dugmici se vide a neki ne. 
//		Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i 
//		last() fukncionalnost za xpath. Koristan link last mehnizma
//		Cekanje od 0.5s
//		Na kraju programa ugasite pretrazivac.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(500);

		driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		Thread.sleep(1000);

		for (int i = 0; i < 5; i++) {

			driver.findElement(By.className("add-new")).click();
			Thread.sleep(500);

			driver.findElement(By.name("name")).sendKeys("Marija");
			Thread.sleep(500);
			driver.findElement(By.name("department")).sendKeys("QA Professionals");
			Thread.sleep(500);
			driver.findElement(By.name("phone")).sendKeys("0697114220");
			Thread.sleep(500);
			driver.findElement(By.xpath("//table/tbody/tr[last()]/td[last()]/a[1]")).click();

//			driver.findElement(By.xpath("//table[contains(@class, 'table table-bordered')]/tbody/tr[last()]/td[last()]/a[1]")).click();

		}

		Thread.sleep(500);
		driver.quit();
	}

}
