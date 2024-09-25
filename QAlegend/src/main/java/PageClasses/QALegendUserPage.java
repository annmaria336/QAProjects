package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegendUserPage {
WebDriver driver;
@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
WebElement addUserOption;
/*By Prefix=By.id("surname");
By FirstName=By.id("first_name");
By LastName=By.id("last_name");
By email=By.id("email");
By userName=By.id("userName");
By password=By.id("password");
By confirmPassword=By.id("confirm_password");
*/
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
WebElement searchButton;

@FindBy(xpath = "(//button[text()=' Delete'])[1]")
WebElement deleteUser;

@FindBy(xpath = "//button[text()='OK']")
WebElement pressOkButtonToDelete;

@FindBy(xpath = "//td[@class='dataTables_empty']")
WebElement errorDetector;

@FindBy(xpath = "//td[text()='Mrs Ann610 Mary']")
WebElement messageDisplayed;

public QALegendUserPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


public void clickOnUserAddOption() {
		PageUtility.clickOnElement(addUserOption);
		
}
/*public WebElement prefixBox() {
	return(driver.findElement(Prefix));       
}
public WebElement FirstNameBox() {
	return(driver.findElement(FirstName));
}
public WebElement LastNameBox() {
	return(driver.findElement(LastName));
}
public WebElement emailBox() {
	return(driver.findElement(email));
	
}
public WebElement userNameBox() {
	return(driver.findElement(userName));
}
public WebElement passwordBox() {
	return(driver.findElement(password));
}
public WebElement confirmPasswordBox() {
	return(driver.findElement(confirmPassword));
}
*/
public void insertUserDetails(String surname, String firstname, String lastname, String email, 
        String username, String password, String confirmpassword) {
PageUtility.enterText(Surnamebox, surname);
PageUtility.enterText(Firstnamebox, firstname);
PageUtility.enterText(Lastnamebox, lastname);
PageUtility.enterText(Emailbox, email);
PageUtility.enterText(Usernamebox, username);
PageUtility.enterText(Passwordbox, password);
PageUtility.enterText(Confirmpasswordbox, confirmpassword);

}
public void clickOnSaveButton() {
	PageUtility.clickOnElement(submituserbuttonOption);
}
public void enterUserToSearch(String username) {
	PageUtility.enterText(searchButton, username);
}
public void deleteUser() {
	PageUtility.clickOnElement(deleteUser);
}
public void pressOkButtonToDelete() {
	PageUtility.clickOnElement(pressOkButtonToDelete);
}
public String validatingTheMessage() {
	return(PageUtility.getElementText(errorDetector));
	
}

public String messageDisplayedForNewUser() {
	return(PageUtility.getElementText(messageDisplayed));
}
}
