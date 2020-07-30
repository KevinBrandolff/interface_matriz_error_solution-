package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class PaymentServices {

	private static TaxServices currentTax;
	
	public static void onlineService(Contract contract) {
		
		double value = contract.getTotalValue() / contract.getInstallmentsVect().length;
		
		for (int i = 1; i <= contract.getInstallmentsVect().length; i++) {
			Date date = addMonths(contract.getDate(), i);
			contract.getInstallmentsVect()[i] = new Installment(date, currentTax.tax(value, i));
		}
		
	}
	private static Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	
}
