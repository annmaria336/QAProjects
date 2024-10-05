package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;
import Utilities.fakerUtility;

public class salesCommissionAgent {
WebDriver driver;

@FindBy(xpath = "(//span[@class='title'])[4]")
WebElement salesCommissionClick;

@FindBy(xpath = "(//i[@class='fa fa-plus'])[1]")
WebElement clickOnaddSales;

@FindBy(id = "surname")
WebElement surnameBox;

@FindBy(id = "first_name")
WebElement firstnameBox;

@FindBy(id = "last_name")
WebElement lastnameBox;

@FindBy(id = "email")
WebElement emailBox;

@FindBy(id = "contact_no")
WebElement contactnoBox;

@FindBy(id = "address")
WebElement addressBox;

@FindBy(id = "cmmsn_percent")
WebElement commissionperBox;

@FindBy(xpath = "//button[@class='btn btn-primary']")
WebElement saveButtonClick;

@FindBy(xpath = "//input[@class='form-control input-sm']")
WebElement searchCommissionAdd;


@FindBy(xpath = "//div[@class='alert alert-success']")
WebElement successMessage;

@FindBy(xpath = "(//tr[@role='row']//td)[2]")
WebElement emailCell;

public salesCommissionAgent(WebDriver driver) {
	// TODO Auto-generated constructor stub
	PageFactory.initElements(driver, this);
}
public void clickOnSalesCommission() {
	PageUtility.clickOnElement(salesCommissionClick);
}
public void clickOnAddSales() {
	PageUtility.clickOnElement(clickOnaddSales);
}
public String insertUserDetail(String filepath, String sheetname) throws IOException {
	String prefix=ExcelUtility.getString(1, 0, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet2");
	String firstname=ExcelUtility.getString(1, 1, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet2")+fakerUtility.randomNumberGenerator();
	String lastname=ExcelUtility.getString(1, 2, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet2");
	String email=fakerUtility.randomNumberGenerator()+ExcelUtility.getString(1, 3, "//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	String contactno=ExcelUtility.getNumeric(1, 4, "//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	String address=ExcelUtility.getString(1, 5, "//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	String commissionpercentage=ExcelUtility.getNumeric(1, 6, "//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	
	//surnameBox.sendKeys(surname);   //sendkeys use chyth call chyam
PageUtility.enterText(surnameBox, prefix);
PageUtility.enterText(firstnameBox, firstname);
PageUtility.enterText(lastnameBox, lastname);
PageUtility.enterText(emailBox, email);
PageUtility.enterText(contactnoBox, contactno);
PageUtility.enterText(addressBox, address);
PageUtility.enterText(commissionperBox, commissionpercentage);
PageUtility.clickOnElement(addressBox);
return email;
}
public void saveButtonClick() {
	PageUtility.clickOnElement(saveButtonClick);
}
public void searchCommissionAgent(String emailid) {
	WaitUtility.waitForElementVisibility(searchCommissionAdd, 5);
	PageUtility.enterText(searchCommissionAdd, emailid);
}
public boolean emailCellValueFinder() {
	return(PageUtility.isElementDisplayed(emailCell));
}
public boolean isSuccessMessageDisplayed() {
    return successMessage.isDisplayed();
}

}

