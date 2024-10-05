package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class productClass {
WebDriver driver;

@FindBy(xpath = "//i[@class='fa fa-cubes']")
WebElement productspage;

@FindBy(xpath = "//i[@class='fa fa-diamond']")
WebElement brandOption;

@FindBy(xpath = "(//div[@class='box-tools']//following::button[@type='button'])[1]")
WebElement addBrandOption;

@FindBy(xpath = "//input[@class='form-control' and @id='name']")
WebElement brandName;

@FindBy(id = "description")
WebElement shortDescription;

@FindBy(xpath = "//button[@class='btn btn-primary']")
WebElement submitButtonClick;

@FindBy(xpath = "//span[text()='Units']")
WebElement unitOptionClick;

@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
WebElement addUnit;

@FindBy(id = "actual_name")
WebElement addName;

@FindBy(id = "short_name")
WebElement addShortName;

@FindBy(id = "allow_decimal")
WebElement addDecimalValue;

@FindBy(xpath = "//input[@class='form-control input-sm']")
WebElement searchProductAdd;

@FindBy(xpath = "(//td[@class='sorting_1'])[1]")
WebElement searchMessage;

@FindBy(xpath = "(//tr[@role='row']//td)[1]")
WebElement brandNameSearch;

public productClass(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void clickOnProduct() {
	PageUtility.clickOnElement(productspage);
}
public void clickOnBrand() {
	PageUtility.clickOnElement(brandOption);
	
}
public void addBrandOption() {
	PageUtility.clickOnElement(addBrandOption);
}
public void brandName(String value) {
	PageUtility.enterText(brandName, value);
}
public void shortDescription(String value) {
	PageUtility.enterText(shortDescription, value);
}
public void submitButtonClick() {
	PageUtility.clickOnElement(submitButtonClick);
}

public void searchProductAdd(String brandName) {
	WaitUtility.waitForElementVisibility(searchProductAdd, 5);
	PageUtility.enterText(searchProductAdd, brandName);
}
public boolean brandNameSearchText() {
	return(PageUtility.isElementDisplayed(brandNameSearch));
}
public String messageDisplayed() {
	return(PageUtility.getElementText(searchMessage));
}
}
