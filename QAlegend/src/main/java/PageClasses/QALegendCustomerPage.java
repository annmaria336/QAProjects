package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class QALegendCustomerPage {
WebDriver driver;
@FindBy(id = "tour_step4_menu")
WebElement contactsButtonSelect;

@FindBy(xpath = "(//i[@class='fa fa-users'])[2]")
WebElement CustomerGroupsSelect;

@FindBy(xpath = "//div[@class='box-tools']//ancestor::button")
WebElement addCustomerGroup;

@FindBy(xpath = "//input[@class='form-control' and @id='name']")
WebElement nameCustomerGroup;

@FindBy(xpath = "//input[@class='form-control' and @id='amount']")
WebElement percentageValue;

@FindBy(xpath = "//button[@class='btn btn-primary']")
WebElement submitButtonClick;

@FindBy(xpath = "//div[@class='dataTables_filter']//child::input")
WebElement searchTextBox;

@FindBy(xpath = "//button[starts-with(@class,'btn btn-xs btn-danger delete')]")
WebElement deleteTheCustomer;

@FindBy(xpath = "//button[text()='OK']")
WebElement clickOnOkToDelete;

@FindBy(xpath = "//tr[@class='odd']//td")
WebElement searchMessage;

public QALegendCustomerPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickOnContacts() {
	PageUtility.clickOnElement(contactsButtonSelect);
}
public void clickOnCustomerGroups() {
	PageUtility.clickOnElement(CustomerGroupsSelect);
}

public void clickOnAddCustomerGroups() {
	PageUtility.clickOnElement(addCustomerGroup);
}
public void customerGroupName(String value) {
	PageUtility.enterText(nameCustomerGroup, value);

}
public void clickOnCalcPercentage(int value) {
	PageUtility.addIntegerValue(percentageValue, value);
}
public void clickOnSubmitButton() {
	PageUtility.clickOnElement(submitButtonClick);
}
public void CustomerGroupSearch(String value) {
	WaitUtility.waitForElementVisibility(searchTextBox, 5);
	PageUtility.enterText(searchTextBox, value);
}
public void deleteTheCustomerGroup() 
{
	PageUtility.clickOnElement(deleteTheCustomer);
}
public void clickOnOkToDelete() {
	PageUtility.clickOnElement(clickOnOkToDelete);
}
public void clearSearchBox() {
	PageUtility.clearText(searchTextBox);
}
public boolean searchMessage() {
	return(PageUtility.isElementDisplayed(searchMessage));
}
}
