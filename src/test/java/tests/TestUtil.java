package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends TestBase{
	WebDriverWait wait;
	Select s;
	JavascriptExecutor js;
	
	public TestUtil() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor)driver;
	}
	
public WebElement wait_visibilityOfElement(WebElement ele) {
	
	wait.until(ExpectedConditions.visibilityOf(ele));
	return ele;
	
}

public List<WebElement> wait_visibilityOfAllElements(List<WebElement> ele){
	wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	return ele;
	
}

public void selectItemByValue(WebElement ele,String value) {
	s = new Select(ele);
	s.selectByValue(value);
	
	
}

public void selectItemByVisibleText(WebElement ele,String value) {
	s = new Select(ele);
	s.selectByVisibleText(value);
	
	
}

public void scrollIntoElement(WebElement ele) {
	js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");	
	js.executeScript("arguments[0].scrollIntoView();", ele);
}

public void scrollDown() {
	js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 8000);");	

	js.executeScript("window.scrollBy(0,6000)");
}
}
