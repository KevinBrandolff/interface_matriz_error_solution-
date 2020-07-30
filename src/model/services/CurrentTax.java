package model.services;

public class CurrentTax implements TaxServices{

	public double tax(double amount, int x) {
		double tax = ((amount*0.01)*x) + amount;
		tax = tax * 0.02;
		return tax;
	}
	
}
