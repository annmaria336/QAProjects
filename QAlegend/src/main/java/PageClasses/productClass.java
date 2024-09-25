package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

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

@FindBy(xpath = "(//i[@class='fa fa-circle-o']//parent::a)[1]")
WebElement variation;

@FindBy(xpath = "(//i[@class='fa fa-plus'])[1]")
WebElement addVariation;

@FindBy(xpath = "//input[@class='form-control' and @id='name']")
WebElement addVariationName;

@FindBy(xpath = "(//input[@class='form-control'])[2]")
WebElement Addvariationvaluesfield;

//@FindBy(xpath = "(//input[@class='form-control' and @name='variation_values[]'])[2]")
//WebElement addVariationValue2;

@FindBy(xpath = "//button[text()='Save']")
WebElement variationsavebutton;

@FindBy(xpath = "//input[@aria-controls='variation_table']")
WebElement searchButton;

@FindBy(xpath = "(//td[@class='sorting_1'])[1]")
WebElement searchMessage;

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
public void unitOptionClick() {
	PageUtility.clickOnElement(unitOptionClick);
}
public void addUnit() {
	PageUtility.clickOnElement(addUnit);
}
public void addName(String value) {
	PageUtility.enterText(addName, value);
}
public void addShortName(String value) {
	PageUtility.enterText(addShortName, value);
}
public void addDecimalValue(int value) {
	PageUtility.addIntegerValue(addDecimalValue, value);
}
public void clickOnVariation() {
	PageUtility.clickOnElement(variation);
}
public void addVariation() {
	PageUtility.clickOnElement(addVariation);
}
public void addVariationName(String value) {
	PageUtility.enterText(addVariationName, value);
}
public void addVariationValue1(int value) {
	PageUtility.addIntegerValue(Addvariationvaluesfield, value);
}
//public void addVariationValue2(int value) {
	//PageUtility.addIntegerValue(addVariationValue2, value);
//}
public void clickOnSubmitButton() {
	PageUtility.clickOnElement(variationsavebutton);
}
public String searchText(String value) {
	PageUtility.enterText(searchButton, value);
	return value;
	
}
public String messageDisplayed() {
	return(PageUtility.getElementText(searchMessage));
}
public String getBrandName() {
	// TODO Auto-generated method stub
	return null;
}

}
