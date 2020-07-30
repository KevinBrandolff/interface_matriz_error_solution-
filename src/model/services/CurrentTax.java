package model.services;

public class CurrentTax implements TaxServices{

	@Override
	public double tax(double amount, int x) {
		double tax = ((amount*0.01)*x) + amount;
		tax = tax * 1.02;
		return tax;
	}
	
}
