package d20_09_2022_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

//shop phone element - gde je prikazan broj telefona
//contact us link
//sign in link

public class HeaderPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public HeaderPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getPhoneNumber() {
		return driver.findElement(By.xpath("//*[contains(@class, 'shop-phone')]/strong"));
	}

	public WebElement getContactUsLink() {
		return driver.findElement(By.xpath("//*[text()='Contact us']"));
	}

	public WebElement getSignInLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'login')]"));
	}
}
