package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.PageFactory;

import pages.FlightsPage;

public class FlightsTest extends TestBase {
	
	FlightsPage fp;
	
	@BeforeClass
	public void init() {
		fp = PageFactory.initElements(driver, FlightsPage.class);
		
	}
	
	@Test
	public void verifyBooking(){
		fp.bookFlight();
	}

}
