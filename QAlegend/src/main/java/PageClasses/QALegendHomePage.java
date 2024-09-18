package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegendHomePage {
WebDriver driver;
@FindBy(xpath = "//span[text()='User Management']")
WebElement UsesrManagmentOPtion;

@FindBy(xpath = "//span[@class='title']//preceding::i[@class='fa fa-user']")
WebElement UsersOption;

@FindBy(xpath = "//button[text()='End tour']")
WebElement endTourOption;


public QALegendHomePage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickOnUserManagmentOption() {
	PageUtility.clickOnElement(UsesrManagmentOPtion);
}
public void clickOnUserAction() {
	PageUtility.clickOnElement(UsersOption);
}
public void clickOnEndTourOption() {
	PageUtility.clickOnElement(endTourOption);

}
}
