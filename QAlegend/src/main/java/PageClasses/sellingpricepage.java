package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class sellingpricepage {
WebDriver driver;

@FindBy(xpath = "(//span[text()='Selling Price Group']//preceding::i[@class='fa fa-circle-o'])[2]")
WebElement clickOnsellingGroup;

@FindBy(xpath = "(//i[@class='fa fa-plus'])[1]")
WebElement clickOnAddSellingPriceGroup;

@FindBy(xpath = "//input[@class='form-control' and @id='name']")
WebElement nameBox;

@FindBy(id = "description")
WebElement descriptionBox;

@FindBy(xpath = "//button[@class='btn btn-primary']")
WebElement saveButtonClick;

@FindBy(xpath = "//input[@type='search']")
WebElement clickOnSearch;

@FindBy(xpath = "//tr[@class='odd']//parent::td[text()='\"ABCD\"1544']")
WebElement elementToVerify;

public sellingpricepage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void clickOnSellingGroup() {
	PageUtility.clickOnElement(clickOnsellingGroup);
}
public void clickOnAddSellingGroup() {
	PageUtility.clickOnElement(clickOnAddSellingPriceGroup);
}
public void nameandDescription(String name, String description) {
	PageUtility.enterText(nameBox, name);
	PageUtility.enterText(descriptionBox, description);
}
public void saveButtonClick() {
	PageUtility.clickOnElement(saveButtonClick);
}
public WebElement searchButtonClick(String value) {
	PageUtility.enterText(clickOnSearch, value);
	return clickOnSearch;
}

public String elementToVerify() {
	return PageUtility.getElementText(elementToVerify);
}
}
