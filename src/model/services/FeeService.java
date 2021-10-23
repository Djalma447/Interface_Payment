package model.services;

public interface FeeService {

	public double fee(double amount, int month);
	public double installment(double fee);
}
