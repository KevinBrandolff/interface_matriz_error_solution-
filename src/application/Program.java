package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.PaymentServices;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.println("Number: ");
		int number = sc.nextInt();
		System.out.println("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.println("Contract value: ");
		double totalValue = sc.nextDouble();
		System.out.println("Enter number of installments: ");
		int numberOfInstallments = sc.nextInt();
		
		Contract contract = new Contract(number, date, totalValue, numberOfInstallments);
		
		PaymentServices.onlineService(contract);
		
		System.out.println("Installments: ");
		
		for (Installment x : contract.getInstallmentsVect()) {
			System.out.println(x);
		}
		
	}

}
