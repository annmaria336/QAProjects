package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.DateUtility;
import Utilities.PageUtility;

public class QALegenStockAdjustmentPage {
WebDriver driver;
@FindBy(xpath = "//i[@class='fa fa-database']")
WebElement stockAdjustmentOption;

@FindBy(xpath = "(//i[@class='fa fa-plus-circle'])[6]")
WebElement addStockOption;

@FindBy(xpath = "//span[@id='select2-location_id-container']")
WebElement addBusinessLocation;

@FindBy(id = "ref_no")
WebElement referenceNo;

@FindBy(id = "transaction_date")
WebElement addDate;

@FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
WebElement clickONSave;

public QALegenStockAdjustmentPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
this.driver=driver;
PageFactory.initElements(driver, this);
}

public void clickOnStockAdjustmentOption() {
	PageUtility.clickOnElement(stockAdjustmentOption);
}
public void clickOnAddStockOption() {
	PageUtility.clickOnElement(addStockOption);
}
public static void clickOnAddBusinessLocation(WebElement element, String value) {
	Select drp=new Select(element);
	drp.selectByVisibleText("Demo Company (BL0001)");
}
public void enterReferenceNo(int value) {
	PageUtility.addIntegerValue(referenceNo, value);
	
}
public void addDate(String string) {
	DateUtility.getCurrentData();
}

public void clickonSave() {
	PageUtility.clickOnElement(clickONSave);
}

}
