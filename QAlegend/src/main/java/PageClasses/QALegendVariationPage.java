package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegendVariationPage {
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
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement searchVariationAdd;
	
	@FindBy(xpath = "(//tr[@role='row']//td)[1]")
	WebElement variationNameSearch;
	
	public QALegendVariationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
       PageFactory.initElements(driver, this);
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
	public void searchVariationAdd(String values) {
		PageUtility.enterText(searchVariationAdd, values);
	}
	public boolean variationNameSearchMessage() {
		return(PageUtility.isElementDisplayed(variationNameSearch));
	}
}
