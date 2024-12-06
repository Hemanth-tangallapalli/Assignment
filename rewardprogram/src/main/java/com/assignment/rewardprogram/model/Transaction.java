package com.assignment.rewardprogram.model;

import java.time.LocalDate;

public class Transaction {
	
	private String customerId;
	private int amountSpent;
	private LocalDate transactionDate;
	public Transaction(String customerId, int amountSpent, LocalDate transactionDate) {
		super();
		this.customerId = customerId;
		this.amountSpent = amountSpent;
		this.transactionDate = transactionDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getAmountSpent() {
		return amountSpent;
	}
	public void setAmountSpent(int amountSpent) {
		this.amountSpent = amountSpent;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	

}
