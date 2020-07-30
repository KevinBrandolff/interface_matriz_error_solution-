package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class PaymentServices {

	private static TaxServices currentTax;
	
	public static void onlineService(Contract contract, int numberOfInstallments) {
		
		double value = contract.getTotalValue() / numberOfInstallments;
		
		for (int i = 1; i <= numberOfInstallments; i++) {
			Date date = addMonths(contract.getDate(), i);
			contract.addInstallment(new Installment(date, currentTax.tax(value, i)));
		}
		
	}
	private static Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	
}
