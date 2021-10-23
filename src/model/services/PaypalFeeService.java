package model.services;

public class PaypalFeeService implements FeeService {

	@Override
	public double fee(double amount, int month) {
		return amount + (amount * 0.01 * month); 
	}

	@Override
	public double installment(double fee) {
		return fee + (fee * 0.02);
	}

}
