package com.juaracoding.catatankeuangan;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.juaracoding.catatankeuangan.BaseTestClass;
import com.relevantcodes.extentreports.LogStatus;

public class StepDefinition extends BaseTestClass{
	
	
	@Test(priority = 1, description = "User menambahkan pengeluaran")
	public void testAddExpense() {
		logger = reports.startTest("Aplikasi Catatan Keuangan");
		catatanKeuanganApp.addPengeluaran("50000", "Makan siang");
		assertEquals(catatanKeuanganApp.getTxtExpense(), "50.000");
		
	}
	
	@Test(priority = 2, description = "User menambahkan pemasukan")
	public void testAddIncome() {
		catatanKeuanganApp.addPemasukan("1000000", "Gaji");
		assertEquals(catatanKeuanganApp.getTxtIncome(), "1.000.000");
	}
	
	
	
	
	

}
