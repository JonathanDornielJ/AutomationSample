package com.banking.testcases;

import java.io.IOException;
import java.util.*;

import org.testng.Assert;
import org.testng.annotations.*;

import com.banking.data.Utilities;
import com.banking.pageobjects.ManagerPage;
import com.banking.pageobjects.NewCustomerPage;
import com.banking.testcomponents.BaseTest;

public class TestOne extends BaseTest {

	@Test(dataProvider = "getData")
	public void TC_1(HashMap<String, String> input) throws InterruptedException {
		ManagerPage managerPage = loginPage.enterLoginDetails("mngr448510", "EjAnAja");
		Assert.assertEquals(managerPage.getScrollHeading(), "Welcome To Manager's Page of Guru99 Bank");
		NewCustomerPage customerPage = managerPage.navigateToNewCustomerPage();
		Thread.sleep(4000);
		customerPage.customerNameGenderDob(input.get("name"), input.get("gender"), "23061998");
		customerPage.enterAddress("No 26 James street", "Edinburgh", "London", "600073");
		customerPage.contactDetails("8888555577", input.get("email"));
		customerPage.setAccountPassword("1234jdjd");
		Thread.sleep(4000);
		tearDown();
	}

	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> mapOne = new HashMap<>();
		mapOne.put("name", "Jona");
		mapOne.put("gender", "m");
		mapOne.put("email", "jona@gmail.com");

		HashMap<String, String> mapTwo = new HashMap<>();
		mapTwo.put("name", "Amanda");
		mapTwo.put("gender", "f");
		mapTwo.put("email", "amanda@yahoo.com");

		return new Object[][] { { mapOne }, { mapTwo } };
	}

//	@DataProvider
//	public Object[][] getData() throws IOException {
//		Utilities util=new Utilities();
//		List<HashMap<String, String>> data = util.convertJSONToMap(System.getProperty("user.dir")
//				+"\\src\\java\\test\\com\\banking\\data\\newCustomerInfo.json");
//		
//		return new Object[][] {{data.get(0)},{data.get(1)}};
//	}
}
