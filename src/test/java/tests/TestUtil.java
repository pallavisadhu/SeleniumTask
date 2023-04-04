package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends TestBase{
	WebDriverWait wait;
	
	public TestUtil() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
public WebElement wait_visibilityOfElement(WebElement ele) {
	
	wait.until(ExpectedConditions.visibilityOf(ele));
	return ele;
	
}

public List<WebElement> wait_visibilityOfAllElements(List<WebElement> ele){
	wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	return ele;
	
}
}
