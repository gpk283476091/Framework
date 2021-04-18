package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaaseClass {

	
	 //no need of Main Method
	 public static WebDriver driver;
//--------------------------------------------------------------
	public void getDriver() {
		WebDriverManager.chromedriver().setup();
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	public void launchUrl(String s) {
		driver.get(s);
	}
	public void title() {
		
		driver.getTitle();
	}
	public void currentUrl() {
		driver.getCurrentUrl();
	}
	
	public void navigateForward() {
driver.navigate().forward();
	}
	
	public void navigateRefresh() {
		driver.navigate().refresh();
		

	}
	public void navigateBack() {
		driver.navigate().back();

	}
	
	public void implicitWait(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);

	}
	public void clear(WebElement element) {
element.clear();
	}
	
	
	public void alertIS(int a) {
WebDriverWait wait = new WebDriverWait(driver, a);
wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void elementClickable(int a, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, a);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void elementSelected(int a, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, a);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void visibilityElement(int a, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, a);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void visibilityElements(int a, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, a);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}
	
	public void presenceElement(int a) {
		WebDriverWait wait = new WebDriverWait(driver, a);
		wait.until(ExpectedConditions.presenceOfElementLocated(null));
				}
	
	
//WebElement methods-------------------------------------------
	public void enterText(WebElement element, String s) {
		element.sendKeys(s);

	}
	public void btnClick(WebElement element) {
		element.click();

	}
	public String text(WebElement element) {
	String text = element.getText();
	
	return text;

	}
	
	public String regularAttribute(WebElement element , String value) {
		String text = element.getAttribute(value);
		System.out.println( " Order number is " +text);
		return text;

	}
	
	
	
//Actions Methods---------------------------------------------
	public void draganddrop(WebElement source, WebElement Destination) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, Destination).perform();
	}
	public void moveto(WebElement target) {
	Actions a = new Actions(driver);
	a.moveToElement(target);
	}
	public void rightClick(WebElement right) {
		Actions a = new Actions(driver);
		a.contextClick(right);
	}
	public void doubleClick(WebElement d) {
	Actions a = new Actions(driver);
	a.doubleClick(d).perform();
	}
	//Alert Methods--------------------------------------------------
	public void simpleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void confirmAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public void promptAlert(String s) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(s);
	}
	//TakesScreenShot ----------------------------------
	public void screenshot(String data) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File (System.getProperty("user.dir")+"\\target\\"+data+".png");
		FileUtils.copyFile(source, destination);
	}
	
		//DropDown---------------------------------------------------
	public void visibleText(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
		
		
	}
	
	public void deSelectVisible(WebElement element,String value) {
		Select s = new Select(element);
		s.deselectByVisibleText(value);
		
		
	}
	public void visibleIndex(WebElement element , int value) {
		Select s = new Select(element);
		s.selectByIndex(value);

	}
	public void multipleCheck(WebElement element ) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}
	public void options(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i <options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
		}
		public void optionsParticularValue(WebElement element,String text1) {
			Select s = new Select(element);
			List<WebElement> options = s.getOptions();
			for (int i = 0; i <options.size(); i++) {
				WebElement webElement = options.get(i);
			    String text = webElement.getText();
				if(text.equals(text1)) {
				s.selectByVisibleText(text);
				}
			}
			}
			public void optionsmorethanonevalue(WebElement element,String text1,String  text2) {
				Select s = new Select(element);
				List<WebElement> options = s.getOptions();
				for (int i = 0; i <options.size(); i++) {
					WebElement webElement = options.get(i);
					String text = webElement.getText();
					if(text.equals(text1) || (text.equals(text2))){
					s.selectByVisibleText(text);
					}
				}
	}
	public void desellect(WebElement element,String value) {
		Select s = new Select(element);
		s.deselectByVisibleText(value);

	}
	public void getFirst(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
System.out.println(firstSelectedOption);
	}
	public void getAllSelected(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			String text = webElement.getText();
			s.selectByVisibleText(text);
		}
	}
		public void evenValue(WebElement element,String text1) {
			Select s = new Select(element);
			List<WebElement> options = s.getOptions();
			for (int i = 0; i <options.size(); i++) {
				if (i%2==0) {
					s.selectByVisibleText(text1);
					System.out.println(text1);
				}
			}
	}
		public void oddValue(WebElement element,String text1) {
			Select s = new Select(element);
			List<WebElement> options = s.getOptions();
			for (int i = 0; i <options.size(); i++) {
				if (i%2==1) {
					s.selectByVisibleText(text1);
					System.out.println(text1);
				}
				}
	}
	//WindowHandling--------------------------------------------------
	public void getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
	}
	public void getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			if (!(string.equals(windowHandles))) {
				driver.switchTo().window(string);
			}
			
		}
}
	public void switchWindow(String s) {
		driver.switchTo().window(s);

	}
	//JavaScriptExecutor-------------------------------------------
	public void javaScriptScrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public void javaScriptScrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView(false)", element);

	}
	
	public void getAttribute(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object executeScript = js.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println(executeScript);
	}
	public void setAttribute(String name ,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object executeScript = js.executeScript("arguments[0].getAttribute(name,'value')", element);
		System.out.println(executeScript);
	}
	
	///Excel BaseClass--------------------------------------------------------------------------------------------------
	
	public void getDataExcel(String path, String sheetname, int rownum, int cellnum) throws IOException {
		File file = new File(path);
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);

	}
	
	public void getDataFromExcel(String path, String sheetname, int rownum, int cellnum) throws IOException {
		File file = new File(path);
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		String Value ="";
		if(cellType==1) {
		Value = cell.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
Value=simpleDateFormat.format(dateCellValue);
		}
		else {
			double numericCellValue = cell.getNumericCellValue();
		long l = (long) numericCellValue;
		System.out.println(l);
		}
				
	}
	
	public void ExcelOut(String path,String name, int rowvalue, int cellvalue,String value) throws IOException {
		File file = new File(path);
		Workbook workbook = new  XSSFWorkbook();
		Sheet sheet = workbook.createSheet(name);
		Row row = sheet.createRow(rowvalue);
		Cell createRow = row.createCell(cellvalue);
		createRow.setCellValue(value);
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
	}
	//---------------------------------------------------------
	public void thread(long value) throws InterruptedException {
		Thread.sleep(value);
	}
	
	public void close() {
		driver.close();
	}
	private void quit() {
		driver.quit();
	}
	
}

	
	
	
