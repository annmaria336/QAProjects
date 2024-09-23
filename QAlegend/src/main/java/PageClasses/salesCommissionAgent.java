package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

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
public void insertUserDetail(String surname, String firstname, String lastname, String email, 
        String contactno, String address, String commissionpercentage) {
PageUtility.enterText(surnameBox, surname);
PageUtility.enterText(firstnameBox, firstname);
PageUtility.enterText(lastnameBox, lastname);
PageUtility.enterText(emailBox, email);
PageUtility.enterText(contactnoBox, contactno);
PageUtility.enterText(addressBox, address);
PageUtility.enterText(commissionperBox, commissionpercentage);
PageUtility.clickOnElement(addressBox);
}
public void saveButtonClick() {
	PageUtility.clickOnElement(saveButtonClick);
}

}

