package model.entities;

import java.util.Date;

public class Installment {

	private Date duoDate;
	private Double amount;
	
	public Installment(Date duoDate, Double amount) {
		this.duoDate = duoDate;
		this.amount = amount;
	}

	public Date getDuoDate() {
		return duoDate;
	}

	public void setDuoDate(Date duoDate) {
		this.duoDate = duoDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
