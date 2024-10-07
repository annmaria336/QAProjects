package QALegendTestcases;

import static org.testng.Assert.assertEquals;

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
import PageClasses.QALegendContactPage;
import PageClasses.QALegendCustomerPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendLoginPage;
import PageClasses.QALegendRolesPage;
import PageClasses.QALegendUserPage;
import PageClasses.QALegendVariationPage;
import PageClasses.productClass;
import PageClasses.salesCommissionAgent;
import PageClasses.sellingpricepage;
import Utilities.ExcelUtility;
import Utilities.WaitUtility;
import Utilities.fakerUtility;

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
sellingpricepage sellingpage;
QALegendContactPage contactpage;
QALegendVariationPage variationPage;
WaitUtility waitUtility;
ExcelUtility excelutility;
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
	sellingpage=new sellingpricepage(driver);
	contactpage=new QALegendContactPage(driver);
	variationPage=new QALegendVariationPage(driver);
	waitUtility = new WaitUtility(driver);
	
}
@Test(retryAnalyzer = RetryAnalyzer.class, groups = {"smoketest"})
public void CreatingNewUser() throws IOException {
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	homepage.clickOnUserAction();
	userpage.clickOnUserAddOption();
	String username=userpage.insertUserDetails(excelFilePath,"Sheet1");
	userpage.clickOnSaveButton();
	userpage.enterUserToSearch(username);
	Assert.assertEquals(userpage.messageDisplayedForNewUser(), true);
	System.out.println("Test userCreation passed");
	
	
}
@Test(retryAnalyzer = RetryAnalyzer.class, groups = {"smoketest"})
public void DeletingtheAddedUser() throws IOException {
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	homepage.clickOnUserAction();
	userpage.clickOnUserAddOption();
	userpage.insertUserDetails(excelFilePath,"Sheet1");
	userpage.clickOnSaveButton();
	userpage.enterUserToSearch("Miriam");
	userpage.deleteUser();
	userpage.pressOkButtonToDelete();
	userpage.clearUser();
	userpage.enterUserToSearch("Miriam");
	Assert.assertEquals(userpage.messageDisplayedForNewUser(), true);
	System.out.println("Test deleteUser passed");
	
}
@Test(retryAnalyzer = RetryAnalyzer.class, groups = {"regression"})
public void RolesAddition() throws Exception {
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	rolespage.addRoles();
	rolespage.addRoleButton();
	String role=prop.getProperty("role-value");
	rolespage.addRoleDetails(role);
	rolespage.selectUserType();
	rolespage.saveButtonClick();
	rolespage.searchButtonClick(role);
	rolespage.deleteUser();
	rolespage.clickOnOkButton();
	rolespage.clearSearchBox();
	rolespage.searchButtonClick(role);
	Assert.assertEquals(rolespage.searchMessage(), "No matching records found");
	System.out.println("Test addRoles passed");
	
}

@Test(retryAnalyzer = RetryAnalyzer.class, groups = {"regression"})
public void VerifyCustomerGroupAddition() throws InterruptedException {
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	customergroups.clickOnContacts();
	customergroups.clickOnCustomerGroups();
	customergroups.clickOnAddCustomerGroups();
	customergroups.customerGroupName("STQ");
	customergroups.clickOnCalcPercentage(79);
	customergroups.clickOnSubmitButton();
	customergroups.CustomerGroupSearch("STQ");
	customergroups.deleteTheCustomerGroup();
	customergroups.clickOnOkToDelete();
	customergroups.clearSearchBox();
	customergroups.CustomerGroupSearch("STQ");
    Assert.assertEquals(customergroups.searchMessage(),true);
    System.out.println("Test addCustomerGroups passed");

}
@Test(retryAnalyzer = RetryAnalyzer.class)
public void SalesCommissionAdded() throws IOException, InterruptedException{
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	salescommissionpage.clickOnSalesCommission();
	salescommissionpage.clickOnAddSales();
	String email=salescommissionpage.insertUserDetail(excelFilePath,"Sheet2");
	salescommissionpage.saveButtonClick();
	salescommissionpage.searchCommissionAgent(email);
	System.out.println(salescommissionpage.emailCellValueFinder());
	Assert.assertEquals(salescommissionpage.emailCellValueFinder(), true);
	System.out.println("Test addSalesCommission passed");
}
@Test(retryAnalyzer = RetryAnalyzer.class)
public void VerifyProductBrandAddedSuccessfully() throws IOException, InterruptedException{
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	productPage.clickOnProduct();
	productPage.clickOnBrand();
	productPage.addBrandOption();
	String brandName="Maze"+fakerUtility.randomNumberGenerator();
	productPage.brandName(brandName);
	productPage.shortDescription("Quality");
	productPage.submitButtonClick();
	productPage.searchProductAdd(brandName);
	Assert.assertEquals(productPage.brandNameSearchText(), true);
	System.out.println("Test productAdd passed");
}
@Test(retryAnalyzer = RetryAnalyzer.class)
public void VerifytheVariationAddedsuccessfully() throws IOException, InterruptedException{
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	productPage.clickOnProduct();
	variationPage.clickOnVariation();
	variationPage.addVariation();
	String variationname=prop.getProperty("Variation-name");
	variationPage.addVariationName(variationname);
	variationPage.addVariationValue1(12);
	//productPage.addVariationValue2(35);
	variationPage.clickOnSubmitButton();
    variationPage.searchVariationAdd(variationname);
    Assert.assertEquals(variationPage.variationNameSearchMessage(), true);
    System.out.println("Test variationAdd passed");

}
@Test(retryAnalyzer = RetryAnalyzer.class)
public void VerifyTheSellingPriceAdded() throws InterruptedException {
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	productPage.clickOnProduct();
	sellingpage.clickOnSellingGroup();
	sellingpage.clickOnAddSellingGroup();
	String sellingpricename=prop.getProperty("sellingpricename")+fakerUtility.randomNumberGenerator();
	String qualityproducts=prop.getProperty("quality products")+fakerUtility.randomNumberGenerator();
	sellingpage.nameandDescription(sellingpricename,qualityproducts);
	sellingpage.saveButtonClick();
	sellingpage.searchBoxClick(sellingpricename);
	Assert.assertEquals(sellingpage.elementToVerify(), true);
	System.out.println("Test addSellingPrice passed");
}
@Test//(retryAnalyzer = RetryAnalyzer.class)
public void verifyThatSupplierAdded() throws InterruptedException, IOException  { 
	loginpage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnEndTourOption();
	homepage.clickOnUserManagmentOption();
	contactpage.clickOnContacts();
	contactpage.clickOnSupplier();
	contactpage.clickOnAddSupplier();
	String name = contactpage.supplierDetails("Suppliers" , excelFilePath , "Sheet3");
	contactpage.supplierSaveButton();
	contactpage.contactSearchBox(name);
	Assert.assertEquals(contactpage.messageToVerify(), true);
	System.out.println("Test addContactSupplier passed");
	
}
}
