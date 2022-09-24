package d20_09_2022_Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//continue shopping dugme
//proced to checkout dugme
//element koji vraca atrubute
// proizvoda (sa slike je to desno od devojke)
//element koji cuva quantity
//(takodje desno od devojke)
//element koji cuva total price
//metodu koja ceka da dijalog bude vidljiv
//metodu koja ceka da dijalog bude nevidljiv

public class LayerCartPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public LayerCartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getContinueShoppingButton() {
		return driver.findElement(By.xpath("//*[@title= 'Continue shopping']"));
	}

	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.xpath("//*[@title= 'Proceed to checkout']"));
	}

	public WebElement getProductAtribute() {
		return driver.findElement(By.xpath("//div[contains(@class, 'layer_cart_product_info')]"));
	}

	public WebElement getQuantity() {
		return driver.findElement(By.xpath("//div[contains(@class, 'layer_cart_product_info')]/div/span"));
	}

	public WebElement getTotalPrice() {
		return driver.findElement(By.xpath("//div[contains(@class, 'layer_cart_product_info')]/div[2]/span"));
	}

	public void waitForDialogToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Proceed to checkout']")));
	}

	public void waitForDialogToBeInvisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@title='Proceed to checkout']")));
	}
}
