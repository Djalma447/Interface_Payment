package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class PaymentService {

	private Integer months;
	
	private FeeService feeService;

	public PaymentService(Integer months, FeeService feeService) {
		this.months = months;
		this.feeService = feeService;
	}
	
	public void processInstallment(Contract contract) {
		double amount = contract.getTotalValue() / months;
		Date sourceDate = contract.getDate();
		Calendar cal = Calendar.getInstance();
		
		for (int i = 1; i <= months; i++) {
			double fee = feeService.fee(amount, i);
			double installment = feeService.installment(fee);
			cal.setTime(sourceDate);
			cal.add(Calendar.MONTH, i);
			Date duoDate = cal.getTime();
			contract.getInstallments().add(new Installment(duoDate, installment));
		}
	}
}
