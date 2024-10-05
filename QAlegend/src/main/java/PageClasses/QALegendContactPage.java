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

public class QALegendContactPage {
	WebDriver driver;
WaitUtility waitUtility;
	@FindBy(xpath = "(//i[@class='fa fa-address-book'])[1]")
	WebElement Contactsbutton;

	@FindBy(xpath = "(//i[@class='fa fa-star'])[1]")
	WebElement Suppliersbutton;

	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement Addsupplierbutton;

	@FindBy(xpath = "(//*[@id='contact_type'])[2]")
	WebElement Contacttypebox;

	@FindBy(id = "name")
	WebElement Suppliername;

	@FindBy(id = "supplier_business_name")
	WebElement Businessname;

	@FindBy(id = "contact_id")
	WebElement Contactid;

	@FindBy(id = "tax_number")
	WebElement Taxnumber;

	@FindBy(id = "opening_balance")
	WebElement Openingbalance;
	
	@FindBy(id = "pay_term_type")
	WebElement Payterm;
	
	@FindBy(id = "mobile")
	WebElement mobileNumber;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement supplierSaveButton;
	
	@FindBy(xpath = "//input[@type='search' and @class='form-control input-sm']")
    WebElement contactSearch;	
	
	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement messageDispalyed;
	
	public QALegendContactPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	    }
	public void clickOnContacts() {
		PageUtility.clickOnElement(Contactsbutton);
	}
	public void clickOnSupplier() {
		PageUtility.clickOnElement(Suppliersbutton);
	}
	public void clickOnAddSupplier() {
		PageUtility.clickOnElement(Addsupplierbutton);
	}
	public String supplierDetails(String contacty, String filepath, String sheetname) throws IOException {
		String name=fakerUtility.randomNumberGenerator()+ExcelUtility.getString(1, 0, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet3");
		String businessname=ExcelUtility.getString(1, 1, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet3")+fakerUtility.randomNumberGenerator();
		String contactid=ExcelUtility.getNumeric(1, 2, "//src//main//java//resources//Userdetails.xlsx", "Sheet3")+fakerUtility.randomNumberGenerator();
		String taxnumber=ExcelUtility.getNumeric(1, 3, "//src//main//java//resources//Userdetails.xlsx", "Sheet3");
		String openingbalance=ExcelUtility.getNumeric(1, 4, "//src//main//java//resources//Userdetails.xlsx", "Sheet3");
		String mobile=ExcelUtility.getNumeric(1, 5, "//src//main//java//resources//Userdetails.xlsx", "Sheet3");
		String city=ExcelUtility.getString(1, 6, "//src//main//java//resources//Userdetails.xlsx", "Sheet3");
		PageUtility.selectByVisibleText(Contacttypebox, contacty);
		PageUtility.enterText(Suppliername, name);
		PageUtility.enterText(Businessname, businessname);
		PageUtility.enterText(Contactid, contactid);
		PageUtility.enterText(Taxnumber, taxnumber);
		PageUtility.enterText(Openingbalance, openingbalance);
		PageUtility.enterText(mobileNumber, mobile);
		PageUtility.enterText(mobileNumber, city);
		return name;
	}
	
	public void supplierSaveButton() {
		PageUtility.clickOnElement(supplierSaveButton);
	}
	public void contactSearchBox(String value) {
		WaitUtility.waitForElementVisibility(contactSearch, 5);
		PageUtility.enterText(contactSearch , value);
	}
	public boolean messageToVerify() {
		return(PageUtility.isElementDisplayed(messageDispalyed));
	}
}
