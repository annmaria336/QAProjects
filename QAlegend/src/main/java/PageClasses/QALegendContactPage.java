package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegendContactPage {
	WebDriver driver;

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
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement searchBox;	
	
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
	public void supplierDetails(String contacty, String name , String business, String contaactid, String tax, String Balance, String mobile, String cityname) {
		PageUtility.selectByVisibleText(Contacttypebox, contacty);
		PageUtility.enterText(Suppliername, name);
		PageUtility.enterText(Businessname, business);
		PageUtility.enterText(Contactid, contaactid);
		PageUtility.enterText(Taxnumber, tax);
		PageUtility.enterText(Openingbalance, Balance);
		PageUtility.enterText(mobileNumber, cityname);
	}
	
	public void supplierSaveButton() {
		PageUtility.clickOnElement(supplierSaveButton);
	}
	public void searchBoxInspect(String value) {
		PageUtility.enterText(searchBox , value);
	}
	public String messageToVerify() {
		return(PageUtility.getElementText(messageDispalyed));
	}
}
