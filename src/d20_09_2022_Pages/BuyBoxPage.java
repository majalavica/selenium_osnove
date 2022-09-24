package d20_09_2022_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//BuyBoxPage koja pribavlja:
//input za kolicinu
//select za velicinu
//add to cart dugme
//add to wishlist dugme
//metodu koja vraca element boje. 
//Metoda kao parametar prima naziv boje 
//(npr: “Orange”, “Blue”) a vraca link koji ima atribut title
//prema trazenoj vrednosti.
//metodu koja skrola do ovog dela stranice
//

public class BuyBoxPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public BuyBoxPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getQuantityInput() {
		return driver.findElement(By.id("quantity_wanted"));
	}

	public WebElement getSelectDropDown() {
		return driver.findElement(By.id("group_1"));
//		Select selectCategory = new Select(driver.findElement(By.id("group_1")));
//		return (WebElement) selectCategory;
	}

	public WebElement getAddToCartButton() {
		return driver.findElement(By.name("Submit"));
	}
	
	public WebElement getWishlistButton() {
		return driver.findElement(By.id("wishlist_button"));
	}

	public WebElement getColor(String boja) {
		return driver.findElement(By.xpath("//ul[@id='color_to_pick_list']//a[@title='" + boja + "']"));
	}
	
	public WebElement getscrollToTableElement() {
		new Actions(driver)
		.scrollToElement(driver.findElement(By.xpath("//table[@class='table-data-sheet']")))
		.perform();
		return driver.findElement(By.xpath("//table[@class='table-data-sheet']"));
		
	}
	public WebElement getPriceForOneElement() {
		return this.driver.findElement(By.id("our_price_display"));
	}
}
