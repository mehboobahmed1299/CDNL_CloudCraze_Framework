package utility;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;


import com.ui.constants.Browser;

public class BrowserUtility {

	
	protected ThreadLocal<WebDriver>  wd=new ThreadLocal<WebDriver>();
	private WebDriverWait wait;

	public BrowserUtility(WebDriver wd) {
		this.wd.set(wd);;
		wait=new WebDriverWait(wd, Duration.ofSeconds(30L));
	}
	
	public WebDriver getWd() {
		return wd.get();
	}

	public BrowserUtility(Browser browserName,boolean isHeadless) {
		if(browserName==Browser.CHROME) {
			ChromeOptions options = new ChromeOptions();
			if(isHeadless) {
				options.addArguments("--headless=new");
			    options.addArguments("--window-size=1920,1080");
			}
			options.addArguments("--incognito");
			wd.set(new ChromeDriver(options)); ;
			wait=new WebDriverWait(wd.get(), Duration.ofSeconds(30L));
		}else if(browserName==Browser.EDGE) {
			EdgeOptions options = new EdgeOptions();
			if(isHeadless) {
				options.addArguments("--headless=new");   
			    options.addArguments("--window-size=1920,1080");
			}
			wd.set(new EdgeDriver(options));
			wait=new WebDriverWait(wd.get(), Duration.ofSeconds(30L));
		}else if(browserName==Browser.FIREFOX) {
			FirefoxOptions options = new FirefoxOptions();
			if(isHeadless) {
				options.addArguments("--headless");
			    options.addArguments("--window-size=1920,1080");
			}
			wd.set(new FirefoxDriver(options));
			wait=new WebDriverWait(wd.get(), Duration.ofSeconds(30L));
		}else {
			System.err.println("Invalid Browser name");
		}

	}
	
	public void goToWebsite(String url) {
		wd.get().get(url);
	}
	
	public void maximizeWindow() {
		wd.get().manage().window().maximize();
	}
	public void deleteCookies() {
		wd.get().manage().deleteAllCookies();
		JavascriptExecutor js = (JavascriptExecutor)wd.get();
	    js.executeScript("window.localStorage.clear();");
	    js.executeScript("window.sessionStorage.clear();");
	    wd.get().navigate().refresh();
	}
	
	public void enterText(By locator,String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
	}
	public void clickOn(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
	}
	public String getText(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}
	public void uploadFile(By locator, String filePath) {
	    wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(filePath);
	}

	public void switchToNewWindow() {
		String parentHandle=wd.get().getWindowHandle();
		for(String handle:wd.get().getWindowHandles()) {
			if(!handle.equals(parentHandle)) {
				wd.get().switchTo().window(handle);
				break;
			}
		}
	}
	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) wd.get();
		js.executeScript("arguments[0].scrollIntoView(true);",wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
	}
	public String takeScreenShot(String fileName) {
		 TakesScreenshot screenshot=(TakesScreenshot)wd.get();
		 File src=screenshot.getScreenshotAs(OutputType.FILE);
		 String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		 String path=System.getProperty("user.dir")+"//screenshots//"+fileName+"_"+ timeStamp+ ".png";
		 try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return path;
	}
}
