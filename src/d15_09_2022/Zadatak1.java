package d15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		Napisati program koji:
//			Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//			Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//			POMOC: Brisite elemente odozdo.
//			(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		Thread.sleep(1000);

		List<WebElement> close = driver.findElements(By.xpath("//button[@type= 'button']"));

		for (int i = 0; i < close.size(); i++) {
			close.get(i).click();
			Thread.sleep(1000);
		}

		boolean elementExist = driver.findElements(By.xpath("//button[@type= 'button']")).size() == 0;

		if (elementExist) {
			System.out.println("Uspesno obrisano!");
		} else {
			System.out.println("Neuspesno obrisano!");
		}

		Thread.sleep(5000);
		driver.quit();

	}

}
