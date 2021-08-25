package com.revature.pms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "customertransaction")

public class CustomerTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	@Column
	private int customerId;
	
	@Column
	private int balance;
	
	@Column
	private int withdrawn;
	
	@Column
	private int deposit;
	
	@Column
	private int transferredAmount;
	
	@Column
	private Date transactionDate;
	

	@Column
	private int toAccount;
	

	@Column
	private int fromAccount;

	public CustomerTransaction(){
		
	}
	
	public CustomerTransaction(int transactionId,int customerId, int balance, int deposit , int toAccount,int fromAccount,Date transactionDate, int transferredAmount,int withdrawn) {
		super();
		this.transactionId=transactionId;
		this.customerId = customerId;
		this.balance = balance;
		this.withdrawn = withdrawn;
		this.deposit = deposit;
		this.toAccount=toAccount;
		this.fromAccount = fromAccount;
		this.transferredAmount = transferredAmount;
		this.transactionDate = transactionDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getWithdrawn() {
		return withdrawn;
	}

	public void setWithdrawn(int withdrawn) {
		this.withdrawn = withdrawn;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getTransferredAmount() {
		return transferredAmount;
	}

	public void setTransferredAmount(int transferredAmount) {
		this.transferredAmount = transferredAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getToAccount() {
		return toAccount;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	public int getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}

	@Override
	public String toString() {
		return "CustomerTransaction [transactionId=" + transactionId + ", customerId=" + customerId + ", balance="
				+ balance + ", withdrawn=" + withdrawn + ", deposit=" + deposit + ", transferredAmount="
				+ transferredAmount + ", transactionDate=" + transactionDate + ", toAccount=" + toAccount
				+ ", fromAccount=" + fromAccount + "]";
	}

	
	

	
}
