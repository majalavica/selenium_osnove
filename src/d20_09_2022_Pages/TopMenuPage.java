package d20_09_2022_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

//metodu koja vraca WOMEN link iz glavnom menija
//metodu koja vraca DRESSES link iz glavnom menija
//metodu koja vraca T-SHIRTS link iz glavnom menija
//metodu koja vraca podmeni za WOMEN
//metodu koja vraca podmeni za DRESSES

public class TopMenuPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public TopMenuPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getWomenLink() {
		return driver.findElement(By.xpath("//*[text()='Women']"));
	}

	public WebElement getDressesLink() {
		return driver.findElement(By.xpath("//*[text()='Dresses']"));
	}

	public WebElement getTShirtsLink() {
		return driver.findElement(By.xpath("//*[text()='T-shirts']"));
	}

	public WebElement getWomanSubmenu() {
		return driver.findElement(By.xpath("//*[contains(@class, 'submenu-container')]"));
	}

	public WebElement getDressesSubmenu() {
		return driver.findElement(By.xpath("//*[contains(@class, 'submenu-container')]"));
	}
}
