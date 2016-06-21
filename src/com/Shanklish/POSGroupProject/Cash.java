package com.Shanklish.POSGroupProject;

public class Cash extends Pay {

	private double cashReceived;
	private double roundOff;
	private double change;

	public Cash(double cash) {

		cashReceived = cash;

	}

	public double calcChange(double cash) {

		if (cashReceived < grandTotal) {

			System.out.println("I need more money. Give me more.");

		} else if (cashReceived >= grandTotal) {

			change = cashReceived - grandTotal;
			roundOff = Math.round(change * 100.0) / 100.0;

		}

		return roundOff;
	}

	public double getCashReceived() {
		return cashReceived;
	}

	public void setCashReceived(double cashReceived) {
		this.cashReceived = cashReceived;
	}

}
