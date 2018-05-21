package com.luv2code.aopdemo;

public class Account {

	private String accName;
	private int accNumber;
	public String getAccName() {
		return accName;
	}

	public Account() {

	}

	public Account(String accName, int accNumber) {
		this.accName = accName;
		this.accNumber = accNumber;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	@Override
	public String toString() {
		return "Account [accName=" + accName + ", accNumber=" + accNumber + "]";
	}
	
}
