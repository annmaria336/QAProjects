package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegendLoginPage {
	WebDriver driver;
@FindBy(id = "username")
	WebElement usernametextbox;
	
@FindBy(id = "password")
WebElement passwordtextbox;

@FindBy(xpath = "//button[@class='btn btn-primary']")
WebElement loginbutton;
	

	public QALegendLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}
	public void loginToQALegend(String username, String password) {
PageUtility.enterText(usernametextbox, username);
PageUtility.enterText(passwordtextbox, password);
PageUtility.clickOnElement(loginbutton);
	}

}
