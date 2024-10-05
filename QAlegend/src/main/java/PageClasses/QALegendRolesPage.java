package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegendRolesPage {
public WebDriver driver;
@FindBy(xpath = "(//i[@class='fa fa-briefcase'])[1]")
WebElement element;

@FindBy(xpath = "//i[@class='fa fa-plus']//preceding::a[@class='btn btn-block btn-primary']")
WebElement addrole;

@FindBy(xpath = "//input[@class='form-control']")
WebElement addRoledetails;

@FindBy(xpath = "//ins[@class='iCheck-helper']//parent::div")
WebElement userType;

@FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
WebElement saveButton;

@FindBy(xpath = "//input[@class='form-control input-sm']")
WebElement searchButton;

@FindBy(xpath = "//button[starts-with(@class,'btn btn-xs btn')]")
WebElement deleteRole;

@FindBy(xpath = "(//button[starts-with(@class,'swal-button swal')])[2]")
WebElement okButtonToDelete;

@FindBy(xpath = "//td[@class='dataTables_empty']")
WebElement searchMessage;

public QALegendRolesPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void addRoles() {  //wrap-encapsulation
	PageUtility.clickOnElement(element);
}
public void addRoleButton() {
	PageUtility.clickOnElement(addrole);
}
public void addRoleDetails(String value) {
	PageUtility.enterText(addRoledetails, value);
}
public void selectUserType() {
	userType.click();
	JavascriptExecutor executor1=(JavascriptExecutor)driver;
	executor1.executeScript("window.scrollBy(0,1000)"); 
}
public void saveButtonClick() {
	PageUtility.clickOnElement(saveButton);
}
public void searchButtonClick(String value) {
	PageUtility.enterText(searchButton, value);
}
public void deleteUser() {
	PageUtility.clickOnElement(deleteRole);	
}
public void clickOnOkButton() {
	PageUtility.clickOnElement(okButtonToDelete);
}
public void clearSearchBox() {
	PageUtility.clearText(searchButton);
}
public String searchMessage() {
	return(PageUtility.getElementText(searchMessage));
}
}
