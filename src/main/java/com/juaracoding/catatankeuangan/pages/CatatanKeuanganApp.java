package com.juaracoding.catatankeuangan.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class CatatanKeuanganApp {
	AndroidDriver<MobileElement> driver;
	
	public CatatanKeuanganApp(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	By btnAllow  = By.id("com.android.packageinstaller:id/permission_allow_button");
	By btnAdd  = By.id("com.chad.financialrecord:id/fabMenu");
	By fieldDate  = By.id("com.chad.financialrecord:id/tvDate");
	By fieldCategory  = By.id("com.chad.financialrecord:id/llForm");
	By fieldIncome = By.id("com.chad.financialrecord:id/tvName");
	By fieldAmount  = By.id("com.chad.financialrecord:id/etAmount");
	By fieldNote  = By.id("com.chad.financialrecord:id/etNote");
	By btnSave  = By.id("com.chad.financialrecord:id/btSave");
	By btnIncome  = By.id("com.chad.financialrecord:id/btnIncome");
	By btnOK  = By.xpath("//android.widget.Button[contains(@text, 'OK')]");
	By btnClose  = By.xpath("//android.widget.Button[contains(@text, 'TUTUP')]");
	By dropdownMakanan  = By.xpath("//android.widget.TextView[contains(@text, 'Makanan')]");
	By dropdownGaji  = By.xpath("//android.widget.TextView[contains(@text, 'Gaji')]");
	By txtExpense = By.xpath("//android.widget.TextView[contains(@text, '50.000')]");
	By txtIncome = By.xpath("//android.widget.TextView[contains(@text, '1.000.000')]");
	By tanggal = By.xpath("//android.view.View[contains(@index, '6')]");
	
	
	
	public void addPengeluaran(String amount, String notes) {
		tunggu(5);
		driver.findElement(btnAllow).click();
		tunggu(5);
		driver.findElement(btnClose).click();
		tunggu(5);
		driver.findElement(btnAdd).click();
		tunggu(10);
		driver.findElement(fieldDate).click();
		tunggu(5);
		driver.findElementByAccessibilityId("08 April 2022").click();
		tunggu(5);
		driver.findElement(btnOK).click();
		tunggu(5);
		driver.findElement(fieldCategory).click();
		tunggu(5);
		driver.findElement(dropdownMakanan).click();
		tunggu(5);
		driver.findElement(fieldAmount).sendKeys(amount);
		tunggu(5);
		driver.findElement(fieldNote).sendKeys(notes);
		tunggu(5);
		driver.findElement(btnSave).click();
		tunggu(10);
		
	}
	
	public void addPemasukan(String amountIncome, String notesIncome) {
		driver.findElement(btnAdd).click();
		tunggu(5);
		driver.findElement(btnIncome).click();
		tunggu(5);
		driver.findElement(fieldDate).click();
		tunggu(5);
		driver.findElementByAccessibilityId("08 April 2022").click();
		tunggu(5);
		driver.findElement(btnOK).click();
		tunggu(5);
		driver.findElement(fieldIncome).click();
		tunggu(5);
		driver.findElement(dropdownGaji).click();
		tunggu(5);
		driver.findElement(fieldAmount).sendKeys(amountIncome);
		tunggu(5);
		driver.findElement(fieldNote).sendKeys(notesIncome);
		tunggu(5);
		driver.findElement(btnSave).click();
		tunggu(10);
		
	}
	
	
	public String getTxtExpense() {
		return driver.findElement(txtExpense).getText();
	}
	
	public String getTxtIncome() {
		return driver.findElement(txtIncome).getText();
	}
	
	
	
	public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Untuk menambahkan fitur scroll
	public void scroll(int startX, int startY, int endX, int endY) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
	}


}
