package com.fdmgroup.Ood_Corwin.Yip;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

public class Runner {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		String transactionsFile = "src/main/resources/transactions.txt";
		String UserFile = "src/main/resources/users.json";
		String fxRateFile = "src/main/resources/fx_rates.json";
		Logger logger = LogManager.getLogger(Runner.class);

		User[] userList = UserListHandler.read(UserFile);
//		System.out.println(user[1].getWallet());

		List<String> transactionList = TextFileReader.readFileToArrayList(transactionsFile);
//		System.out.println(transactionList.get(0));

		Map<String, FxRate> fxRateList = FxRateReader.read(fxRateFile);
//		System.out.println(fxRateList);

		Converter converter = new Converter(fxRateList);
		TransactionProcessor transactionProcessor = new TransactionProcessor(userList);
		for (String transaction : transactionList) {

			System.out.println(transaction);
			String[] transactionLine = transaction.split(" ");

			String name = transactionLine[0];
			String fromCurrency = transactionLine[1];
			String toCurrency = transactionLine[2];
			String amount = transactionLine[3];
			double amountOfTransaction = Double.parseDouble(amount);
			Boolean containName = false;

			if (!fxRateList.containsKey(fromCurrency) && !fromCurrency.equals("usd")) {

				logger.info("SKIP: invalid from currency type :" + fromCurrency);

			} else if (!fxRateList.containsKey(toCurrency) && !toCurrency.equals("usd")) {
				logger.info("SKIP: invalid to currency type :" + toCurrency);
			} else {
				for (User user : userList) {
					if (user.getName().equals(name)) {
						containName = true;
					}
				}

				if (!containName) {
					logger.info("SKIP: Invalid name entered: " + name);
				} else {

					double convertedAmount = converter.convert(fromCurrency, toCurrency, amountOfTransaction);
					System.out.println("convertedAmount = " + convertedAmount);

					transactionProcessor.executeTransaction(name, fromCurrency, toCurrency, amountOfTransaction,
							convertedAmount);
					containName = false;
				}
			}

		}
		transactionProcessor.updateUserFile(UserFile);

	}

}
