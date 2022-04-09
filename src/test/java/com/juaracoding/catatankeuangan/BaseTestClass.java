package com.juaracoding.catatankeuangan;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.juaracoding.catatankeuangan.pages.CatatanKeuanganApp;
import com.juaracoding.catatankeuangan.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class BaseTestClass {
	
	AndroidDriver<MobileElement> driver;
	ExtentReports reports;
	ExtentTest logger;
	CatatanKeuanganApp catatanKeuanganApp;

	
	@BeforeTest
	public void initReports() {
		reports = new ExtentReports(System.getProperty("user.dir")+"/Reporting/TestReport.html", true);
	}
	
	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Pixel_2_API_24");
		capabilities.setCapability("uuid", "emulator-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("appPackage", "com.chad.financialrecord");
		capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");

		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@BeforeMethod
	public void beforeMethodTest() {
		catatanKeuanganApp = new CatatanKeuanganApp(driver);
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = Utils.screenShot(driver, result.getMethod().getDescription().replace(" ", "_").toLowerCase());
			logger.log(LogStatus.FAIL, result.getMethod().getDescription()+logger.addScreenCapture(screenShotPath));
		} else {
			logger.log(LogStatus.PASS, result.getMethod().getDescription());
		}
		reports.endTest(logger);
	}
	
	@AfterClass
	public void closeApp() {
		reports.flush();
		reports.close();
		tunggu(1);
		driver.quit();
	}
	
	public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scroll() {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(PointOption.point(500, 1500)).moveTo(PointOption.point(500, 500)).release().perform();
	}

}
