package d19_09_2022_Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import p20_09_2022_Pages.BootstrapTablePage;
import p20_09_2022_Pages.DeleteDialogPage;
import p20_09_2022_Pages.EditDialogPage;

public class BootstrapTableTests {

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://s.bootsnipp.com";
	private BootstrapTablePage tablePage;
	private EditDialogPage editDialogPage;
	private DeleteDialogPage deleteDialogPage;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		tablePage = new BootstrapTablePage(driver, wait);
		editDialogPage = new EditDialogPage(driver, wait);
		deleteDialogPage = new DeleteDialogPage(driver, wait);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@Test
	public void editRowTest() {
		driver.get(baseUrl + "/iframe/K5yrx");

		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com");

		tablePage.getEditButtonByRow(0).click();
		editDialogPage.waitForDialogToBeVisible();

		editDialogPage.getFirstNameInput().clear();
		editDialogPage.getFirstNameInput().sendKeys("Marija");

		editDialogPage.getLastNameInput().clear();
		editDialogPage.getLastNameInput().sendKeys("Jovanovic");

		editDialogPage.getMiddleNameInput().clear();
		editDialogPage.getMiddleNameInput().sendKeys("Majce");

		editDialogPage.getUpdateButton().click();

		editDialogPage.waitForDialogToBeInvisible();

		Assert.assertEquals(tablePage.getCell(0, 1).getText(), "Marija", "First name column is not updated.");

		Assert.assertEquals(tablePage.getCell(0, 2).getText(), "Jovanovic", "Last name column is not updated.");

		Assert.assertEquals(tablePage.getCell(0, 3).getText(), "Majce", "Middle name column is not updated.");

	}

	@Test
	public void deleteRowTest() {
		driver.get(baseUrl + "/iframe/K5yrx");

		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com");

		int numberOfRowsBeforeDelete = tablePage.getRows().size();

		tablePage.getDeleteButtonByRow(0).click();
		deleteDialogPage.waitForDialogToBeVisible();
		deleteDialogPage.getDeleteButton().click();
		deleteDialogPage.waitForDialogToBeInvisible();

		Assert.assertEquals(tablePage.getRows().size(), numberOfRowsBeforeDelete, "Row is not deleted from table.");

	}

	@Test
	public void TakeAScreenshot() throws IOException {
		driver.get(baseUrl + "/iframe/K5yrx");
		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"Title should be Table with Edit and Update Data - Bootsnipp.com");
		
		TakesScreenshot screanShot = ((TakesScreenshot) driver);
		File src = screanShot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("img/Screenshot.png");
		FileHandler.copy(src, destinationFile);

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
