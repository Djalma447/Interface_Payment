package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.PaymentService;
import model.services.PaypalFeeService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract ct = new Contract(number, date, totalValue);
		
		System.out.print("Enter number of installments: ");
		int months = sc.nextInt();
		PaymentService ps = new PaymentService(months, new PaypalFeeService());
		ps.processInstallment(ct);
		
		System.out.println("Installments");
		for (Installment i : ct.getInstallments()) {
			System.out.println(sdf.format(i.getDuoDate()) + " - " + String.format("%.2f", i.getAmount()));
		}

		sc.close();
	}
}
