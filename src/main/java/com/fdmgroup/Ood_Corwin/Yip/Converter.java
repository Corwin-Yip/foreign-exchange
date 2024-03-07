package com.fdmgroup.Ood_Corwin.Yip;

import java.util.Map;

public class Converter {
	private Map<String, FxRate> fxRateList;

	public Converter(Map<String, FxRate> fxRateList) {
		this.fxRateList = fxRateList;
	}

	public double convert(String fromCurrency, String toCurrency, Double amount) {
		Double convertedAmount = 0.0;
		Double exchangeRate;
		Double exchangeInverseRate;

		if (fromCurrency.equals("usd")) {
			exchangeInverseRate = 1.0;
		} else {
			exchangeInverseRate = fxRateList.get(fromCurrency).getInverseRate();
		}

		if (toCurrency.equals("usd")) {
			exchangeRate = 1.0;
		} else {
			exchangeRate = fxRateList.get(toCurrency).getRate();
//			System.out.println("exchangeRate "+exchangeRate);
		}

		convertedAmount = amount * exchangeInverseRate * exchangeRate;

		return convertedAmount;

	}
}
