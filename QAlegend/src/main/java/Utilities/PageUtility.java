package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
public static void clickOnElement(WebElement element) 
{
	element.click();	
}
public static void enterText(WebElement element , String value) {
	element.sendKeys(value);
}
public static String getElementText(WebElement element) {
	return(element.getText());
}
public static String getAttribute(WebElement element, String name) {
return(element.getAttribute(name));

}
public static void addIntegerValue(WebElement element, int value) {
    element.sendKeys(String.valueOf(value));
}
public static void clearText(WebElement element)
{
	element.clear();
	}
public static void navigateToBack(WebDriver driver)//driver inte return type webdriver aanu
{
	driver.navigate().back();
}
public static void navigateToForward(WebDriver driver) {
	driver.navigate().forward();
}
public static void navigateTorefresh(WebDriver driver) {
	driver.navigate().refresh();
}
public static void navigateTo(WebDriver driver, String url) {
	driver.navigate().to(url);
}
public static void moveToElements(WebElement element, WebDriver driver)
{
    Actions action=new Actions(driver);
    action.moveToElement(element);
    action.build().perform();
}
public static void selectByVisibleText(WebElement element , String value) {
	Select drp=new Select(element);
	drp.selectByVisibleText(value);
	}
public static void selectByValue(WebElement element , String value) {
	Select drp1=new Select(element);
	drp1.selectByValue(value);
}
public static void selectByIndex(WebElement element , int value) {
	Select drp2=new Select(element);
	drp2.selectByIndex(value);
}
public static boolean isElementDisplayed(WebElement element) {
	return(element.isDisplayed());
	
}
public static boolean isElementEnabled(WebElement element)
{
    return(element.isEnabled());
}

public static boolean isElementSelected(WebElement element)
{
    return(element.isSelected());
}
public static String getPageTitle(WebDriver driver)
{
    return(driver.getTitle());
}
    public static void clickUsingJavaScriptExecter(WebDriver driver, WebElement element)
    {
    JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0]",  driver);
}
    public static void scrollBy(WebDriver driver, WebElement element) {
    	JavascriptExecutor executor1=(JavascriptExecutor)driver;
    	executor1.executeScript("windows.scrollBy(1000)");
    }
    public void enterKeyPress(WebDriver driver, WebElement element)
    {
    	Actions action = new Actions(driver);
    	action.sendKeys(element,Keys.ENTER);
    	action.build().perform();
    }
}


