package com.fdmgroup.Ood_Corwin.Yip;

public class FxRate {
	private String code;
	private String alphaCode;
	private int numericCode;
	private String name;
	private double rate;
	private String date;
	private double inverseRate;

	public FxRate() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAlphaCode() {
		return alphaCode;
	}

	public void setAlphaCode(String alphaCode) {
		this.alphaCode = alphaCode;
	}

	public int getNumericCode() {
		return numericCode;
	}

	public void setNumericCode(int numericCode) {
		this.numericCode = numericCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getInverseRate() {
		return inverseRate;
	}

	public void setInverseRate(double inverseRate) {
		this.inverseRate = inverseRate;
	}
}
