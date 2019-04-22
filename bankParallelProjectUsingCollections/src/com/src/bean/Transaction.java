package com.src.bean;

public class Transaction {
	private int transactionId;
	private long fromAccountNo;
	private long toAccountNo;
	private float amountTransferred;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public long getFromAccountNo() {
		return fromAccountNo;
	}

	public void setFromAccountNo(long fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}

	public long getToAccountNo() {
		return toAccountNo;
	}

	public void setToAccountNo(long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}

	public float getAmountTransferred() {
		return amountTransferred;
	}

	public void setAmountTransferred(float amountTransferred) {
		this.amountTransferred = amountTransferred;
	}
}
