package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tests.TestUtil;

public class FlightsPage {
	
	WebDriver driver;
	TestUtil util;
	WebElement ele;
	List<WebElement> list;

	
	@FindBy(css="div[class='sc-jQrDum hXFakb'] p[class='sc-eLwHnm hHxEGr fswWidgetPlaceholder']")
	WebElement flightsFrom;
	
	@FindBy(css="div[class='sc-jQrDum hgeZJA'] p[class='sc-eLwHnm hHxEGr fswWidgetPlaceholder']")
	WebElement flightsTo;
	
	/*@FindBy(css=".sc-kTLmzF.cJQpup")
	WebElement roundtrip;*/
	
	@FindBy(xpath="(//p[@class='sc-faUpoM clesLa fswWidgetTitle'])[1]")
	WebElement departure;
	
	@FindBy(xpath="(//p[@class='sc-faUpoM clesLa fswWidgetTitle'])[2]")
	WebElement returns;
	
	@FindBy(xpath="(//p[@class='sc-faUpoM clesLa fswWidgetTitle'])[3]")
	WebElement travellers;
	
	@FindBy(css=".sc-kmQMED.fgpXuF")
	WebElement searchFlights;
	
	@FindBy(css="span[role='presentation']")
	WebElement closeBtn;
	
	@FindBy(css=".sc-jlwm9r-1.dRQhOp")
	WebElement closeBtn1;
	
	@FindBy(xpath="//div[@class='sc-GEbAx hOdrcL']//span[text()='From']//following-sibling::input")
	WebElement departureInput;
	
	@FindBy(xpath="//div[@class='sc-GEbAx hOdrcL']//span[text()='To']//following-sibling::input")
	WebElement returnInput;
	
	@FindBy(xpath="//div[@class='sc-ctqQKy evOxvK']")
	List<WebElement> cityList;
	
	@FindBy(css="span[class='fswTrvl__done']")
	WebElement btnDone;
	
	@FindBy(css=".sc-fmciRz.duyTj")
	WebElement btnDone1;
	
	@FindBy(xpath="(//ul[@class='sc-eWfVMQ diuirR']//child::li[@class='sc-kTLmzF ixJFjA']//child::span[@class='sc-jtXEFf ezccfJ'])[1]")
	WebElement roundtrip;
	
	@FindBy(xpath="//div[@class='DayPicker-Month']//div[@class='DayPicker-Caption']//div")
	List<WebElement> monthList;
	
	@FindBy(xpath="//div[@class='DayPicker-Day']//p[@class='fsw__date']")
	List<WebElement> dayList;
	
	@FindBy(xpath="//span[text()='PRICE']")
	List<WebElement> priceList;
	
	@FindBy(css="span[aria-label='Next Month']")
	WebElement nextMonth;
	
	@FindBy(xpath="//div[@class='layoutstyles__Wrapper-sc-am2mfo-0 bYOwwR']")
	List<WebElement> priceCards;
	
	@FindBy(xpath="//input[@value='BOOK']")
	WebElement bookBtn;
	
	@FindBy(xpath="//button[@class='dweb-commonstyles__FltBtn-sc-13fxsy5-12 fwrRNe fb quicksand font16']")
	WebElement nextBtn;
	
	@FindBy(xpath="//button[@class='dweb-commonstyles__FltBtn-sc-13fxsy5-12 fwrRNe fb quicksand font16']")
	WebElement proceedBtn;
	
	@FindBy(css=".dweb-commonstyles__FltBtn-sc-13fxsy5-12.fuCQCF.fb.quicksand.wid25.font16")
	WebElement proceedBtn1;
	
	@FindBy(css=".common-elementsstyles__CustSelectTrvl-sc-ilw4bs-9.jVMraT")
	WebElement selectTitle;
	
	@FindBy(css="input[placeholder='First & Middle Name']")
	WebElement firstName;
	
	@FindBy(css="input[placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(css="input[placeholder='Email']")
	WebElement email;
	
	@FindBy(css=".common-elementsstyles__CustSelectTrvl-sc-ilw4bs-9.bJfThW")
	WebElement selectCountryCode;
	
	@FindBy(css="input[placeholder='Mobile No']")
	WebElement mobileNo;
	
	@FindBy(css=".dweb-commonstyles__ButtonBase-sc-13fxsy5-4.dweb-commonstyles__InsuranceButton-sc-13fxsy5-5.dweb-commonstyles__InsuranceSelectButton-sc-13fxsy5-6.jjNHxX.biOOqn.cgDciw")
	WebElement travelInsurance;
	
	@FindBy(css=".dweb-commonstyles__FltBtn-sc-13fxsy5-12.fuCQCF.width100.fb.quicksand.font16")
	WebElement proceedToPaymentBtn;
	
	@FindBy(xpath="//ul[@class='paymentListCtr']//li//div//span[text()='Mobile Wallets']")
	WebElement choosePayment;
	
	@FindBy(xpath="//span[text()='Amazon Pay']")
	WebElement amazonPay;
	
	
	
	public FlightsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil();
	}
	
	public void bookFlight(){
		closeBtn.click();
		util.wait_visibilityOfElement(closeBtn1).click();
		
		roundtrip.click();
		
		flightsFrom.click();
		util.wait_visibilityOfElement(departureInput).sendKeys("Delhi");;
		
		list = util.wait_visibilityOfAllElements(cityList);
		try {
		for(WebElement e : list) {
			if(e.getText().contains("New Delhi, India")) {
				e.click();
			}
		}
		}catch(StaleElementReferenceException e1) {
			for(WebElement e : list) {
				if(e.getText().contains("New Delhi, India")) {
					e.click();
				}
			}
		}
		
		returnInput.sendKeys("Mumbai");
		list = util.wait_visibilityOfAllElements(cityList);

		try {
		for(WebElement e : list) {
			if(e.getText().contains("Mumbai, India"))
				e.click();
		}
		}catch(StaleElementReferenceException e1) {
			for(WebElement e : list) {
				if(e.getText().contains("Mumbai, India"))
					e.click();
			}
		}
		
		while(!driver.findElement(By.xpath("(//div[@class='DayPicker-Month']//div[@class='DayPicker-Caption']//div)[1]")).getText().equals("June 2023"))
		{
			util.wait_visibilityOfElement(nextMonth).click();
		}
		for(WebElement day : dayList) {
			if(day.getText().equals("10")) {
				day.click();
			}
			
		}
			
		btnDone.click();
		//btnDone.click();
		btnDone1.click();
		searchFlights.click();
		
		list = util.wait_visibilityOfAllElements(priceList);
		list.get(0).click();
		list.get(1).click();
		
		list = util.wait_visibilityOfAllElements(priceCards);
		
		list.get(0).click();
		list.get(1).click();
	
		
		bookBtn.click();
		util.wait_visibilityOfElement(nextBtn).click();
		util.wait_visibilityOfElement(proceedBtn).click();
		
				
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");	
		js.executeScript("arguments[0].scrollIntoView();", selectTitle);*/
		
		util.scrollIntoElement(travelInsurance);
		travelInsurance.click();
		util.scrollIntoElement(selectTitle);
		
		util.selectItemByValue(selectTitle, "Mrs");
		firstName.sendKeys("ABC");
		lastName.sendKeys("XYZ");
		email.sendKeys("testproj@test.com");
		util.selectItemByVisibleText(selectCountryCode, "United States ( +1 )");
		mobileNo.sendKeys("4029992170");
		proceedBtn1.click();
		
		util.scrollIntoElement(proceedToPaymentBtn);
		proceedToPaymentBtn.click();
		
		util.scrollDown();
				
		//util.scrollIntoElement(choosePayment);
		choosePayment.click();
		
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", choosePayment);
		choosePayment.click();*/
		
		util.scrollDown();
		amazonPay.click();
		
	}
	
}
