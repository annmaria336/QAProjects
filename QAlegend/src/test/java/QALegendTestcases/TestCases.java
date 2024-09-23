package QALegendTestcases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QALegenStockAdjustmentPage;
import PageClasses.QALegendCustomerPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendLoginPage;
import PageClasses.QALegendRolesPage;
import PageClasses.QALegendUserPage;
import PageClasses.productClass;
import PageClasses.salesCommissionAgent;
import Utilities.ExcelUtility;

public class TestCases extends BaseClass{
public WebDriver driver;
QALegendLoginPage loginpage;
QALegendHomePage homepage;
QALegendUserPage userpage;
Properties prop;
FileReader reader;
QALegendRolesPage rolespage;
QALegendCustomerPage customergroups;
QALegenStockAdjustmentPage stockadjustmentpage;
salesCommissionAgent salescommissionpage;
productClass productPage;

@BeforeMethod (groups = {"smoketest","regression"})
@Parameters({"Browser"})
public void initialization(String browser) throws Exception
{
	prop=new Properties();
	reader=new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\TestData.properties");
	prop.load(reader);
	driver=browserInitilization(browser);
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();	
	loginpage=new QALegendLoginPage(driver);
	homepage=new QALegendHomePage(driver);
	userpage= new QALegendUserPage(driver);
	rolespage=new QALegendRolesPage(driver);
	customergroups=new QALegendCustomerPage(driver);
	stockadjustmentpage =new QALegenStockAdjustmentPage(driver);
	salescommissionpage=new salesCommissionAgent(driver);
	productPage=new productClass(driver);
	
}
@Test
public void userCreation() throws IOException {
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	homepage.clickOnUserAction();
	userpage.clickOnUserAddOption();
	
	
	
	
	/*userpage.prefixBox().sendKeys("Miss");
	userpage.FirstNameBox().sendKeys("Ann");
	userpage.LastNameBox().sendKeys("Mary");
	userpage.emailBox().sendKeys("annmaria@gmail.com");
	userpage.userNameBox().sendKeys("Annmaria");
	userpage.passwordBox().sendKeys("Midhu@123");
	userpage.confirmPasswordBox().sendKeys("Midhu@123");
	*/
	Random rand=new Random();
	int randomnumber=rand.nextInt(10000);
	String prefix=ExcelUtility.getString(1, 0, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet1");
	String firstname=ExcelUtility.getString(1, 1, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet1")+randomnumber;
	String lastname=ExcelUtility.getString(1, 2, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet1");
	String email=randomnumber+ExcelUtility.getString(1, 3, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	String username=randomnumber+ ExcelUtility.getString(1, 4, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	String password=ExcelUtility.getString(1, 5, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	String confirmpassword=ExcelUtility.getString(1, 6, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	userpage.insertUserDetails(prefix, firstname, lastname, email, username, password, confirmpassword);
	userpage.clickOnSaveButton();
	userpage.enterUserToSearch("Miriam");
	Assert.assertEquals(userpage.messageDisplayedForNewUser(), "Mrs Ann610 Mary");
	
	
}
@Test
public void deleteUser() throws IOException {
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	homepage.clickOnUserAction();
	userpage.clickOnUserAddOption();
	
	
	/*userpage.prefixBox().sendKeys("Miss");
	userpage.FirstNameBox().sendKeys("Ann");
	userpage.LastNameBox().sendKeys("Mary");
	userpage.emailBox().sendKeys("annmaria@gmail.com");
	userpage.userNameBox().sendKeys("Annmaria");
	userpage.passwordBox().sendKeys("Midhu@123");
	userpage.confirmPasswordBox().sendKeys("Midhu@123");
	*/
	Random rand=new Random();
	int randomnumber=rand.nextInt(10000);
	String prefix=ExcelUtility.getString(1, 0, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet1");
	String firstname=ExcelUtility.getString(1, 1, "//src//main//java//resources//Userdetails.xlsx", "Sheet1")+randomnumber;
	String lastname=ExcelUtility.getString(1, 2, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	String email=randomnumber+ExcelUtility.getString(1, 3, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	String username=randomnumber+ ExcelUtility.getString(1, 4, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	String password=ExcelUtility.getString(1, 5, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	String confirmpassword=ExcelUtility.getString(1, 6, "//src//main//java//resources//Userdetails.xlsx", "Sheet1");
	userpage.insertUserDetails(prefix, firstname, lastname, email, username, password, confirmpassword);
	userpage.clickOnSaveButton();
	userpage.enterUserToSearch("Miriam");
	userpage.deleteUser();
	userpage.pressOkButtonToDelete();
	userpage.enterUserToSearch("Miriam");
	Assert.assertEquals(userpage.validatingTheMessage(), "No matching records found");
	
}
@Test
public void addRoles() throws Exception {
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	rolespage.addRoles();
	rolespage.addRoleButton();
	rolespage.addRoleDetails("Executor");
	rolespage.selectUserType();
	Thread.sleep(2000);
	JavascriptExecutor executor1=(JavascriptExecutor)driver;
	executor1.executeScript("window.scrollBy(0,1000)");
	rolespage.saveButtonClick();
	rolespage.searchButtonClick("Executor");
	Assert.assertEquals(rolespage.searchMessage(), "Executor");
	
}

@Test
public void addCustomerGroups() {
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	customergroups.clickOnContacts();
	customergroups.clickOnCustomerGroups();
	customergroups.clickOnAddCustomerGroups();
	customergroups.customerGroupName("STQ");
	customergroups.clickOnCalcPercentage(79);
	customergroups.clickOnSubmitButton();
}
@Test
public void addStockadjustment() {
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	stockadjustmentpage.clickOnStockAdjustmentOption();
	stockadjustmentpage.clickOnAddStockOption();
	stockadjustmentpage.enterReferenceNo(7890);
	stockadjustmentpage.addDate("26/03/1996");
	stockadjustmentpage.clickonSave();
	
}

@Test
public void addSalesCommission() throws IOException{
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	salescommissionpage.clickOnSalesCommission();
	salescommissionpage.clickOnAddSales();
	Random rand=new Random();
	int randomnumber=rand.nextInt(10000);
	String prefix=ExcelUtility.getString(1, 0, "//src\\main\\java\\resources\\Userdetails.xlsx", "Sheet2");
	String firstname=ExcelUtility.getString(1, 1, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet2")+randomnumber;
	String lastname=ExcelUtility.getString(1, 2, "\\src\\main\\java\\resources\\Userdetails.xlsx", "Sheet2");
	String email=randomnumber+ExcelUtility.getString(1, 3, "//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	String contactno=ExcelUtility.getNumeric(1, 4, "//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	String address=ExcelUtility.getString(1, 5, "//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	String commissionpercentage=ExcelUtility.getNumeric(1, 6, "//src//main//java//resources//Userdetails.xlsx", "Sheet2");
	salescommissionpage.insertUserDetail(prefix, firstname, lastname, email, contactno, address, commissionpercentage);
	salescommissionpage.saveButtonClick();
}
@Test
public void productAdd() throws IOException{
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	productPage.clickOnProduct();
	productPage.clickOnBrand();
	productPage.addBrandOption();
	productPage.brandName("Maze");
	productPage.shortDescription("Quality");
	productPage.submitButtonClick();
	//productPage.unitOptionClick();
	//productPage.addUnit();
	//productPage.addName("Ann1");
	//productPage.addShortName("miriam");
	
}
@Test
public void variationAdd() throws IOException{
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	productPage.clickOnProduct();
	productPage.clickOnVariation();
	productPage.addVariation();
	productPage.addVariationName("ABC");
	productPage.addVariationValue(34);
	//productPage.addVariationValue2(35);
	productPage.clickOnSubmitButton();
}
}