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

public class QALegendUserPage {
WebDriver driver;
@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
WebElement addUserOption;

@FindBy(id = "surname")
WebElement Surnamebox;

@FindBy(id = "first_name")
WebElement Firstnamebox;

@FindBy(id = "last_name")
WebElement Lastnamebox;

@FindBy(id = "email")
WebElement Emailbox;

@FindBy(id = "username")
WebElement Usernamebox;

@FindBy(id = "password")
WebElement Passwordbox;

@FindBy(id = "confirm_password")
WebElement Confirmpasswordbox;

@FindBy(id = "submit_user_button")
WebElement submituserbuttonOption;

@FindBy(xpath = "//input[@class='form-control input-sm']")
WebElement searchTextBox;

@FindBy(xpath = "(//button[text()=' Delete'])[1]")
WebElement deleteUser;

@FindBy(xpath = "//button[text()='OK']")
WebElement pressOkButtonToDelete;

@FindBy(xpath = "//input[@class='form-control input-sm']")
WebElement clearText;

@FindBy(xpath = "(//td[@class='sorting_1'])[1]")
WebElement messageDisplayed;

public QALegendUserPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickOnUserAddOption() {
		PageUtility.clickOnElement(addUserOption);
}
public String insertUserDetails(String filepath, String sheetname) throws IOException {
	String prefix=ExcelUtility.getString(1, 0, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet1");
	String firstname=ExcelUtility.getString(1, 1, "//src//main//java//resources//Userdetails.xlsx", "Sheet1")+fakerUtility.randomNumberGenerator();   //avoid repeatedlines
	String lastname=ExcelUtility.getString(1, 2, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	String email=fakerUtility.randomNumberGenerator()+ExcelUtility.getString(1, 3, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	String username=fakerUtility.randomNumberGenerator()+ ExcelUtility.getString(1, 4, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	String password=ExcelUtility.getString(1, 5, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	String confirmpassword=ExcelUtility.getString(1, 6, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
PageUtility.enterText(Surnamebox, prefix);
PageUtility.enterText(Firstnamebox, firstname);
PageUtility.enterText(Lastnamebox, lastname);
PageUtility.enterText(Emailbox, email);
PageUtility.enterText(Usernamebox, username);
PageUtility.enterText(Passwordbox, password);
PageUtility.enterText(Confirmpasswordbox, confirmpassword);
return username;

}
public void clickOnSaveButton() {
	PageUtility.clickOnElement(submituserbuttonOption);
}
public void enterUserToSearch(String username) {
	WaitUtility.waitForElementVisibility(searchTextBox, 5);
	PageUtility.enterText(searchTextBox, username);
}
public void deleteUser() {
	PageUtility.clickOnElement(deleteUser);
}
public void pressOkButtonToDelete() {
	PageUtility.clickOnElement(pressOkButtonToDelete);
}
public void clearUser() {
	PageUtility.clickOnElement(clearText);
}
public boolean messageDisplayedForNewUser() {
	return(PageUtility.isElementDisplayed(messageDisplayed));
}
}
