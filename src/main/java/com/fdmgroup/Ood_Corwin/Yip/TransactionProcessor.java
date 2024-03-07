package com.fdmgroup.Ood_Corwin.Yip;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransactionProcessor {
	private static final Logger logger = LogManager.getLogger(TransactionProcessor.class);
	private User[] userList;
	User currentUser;

	public TransactionProcessor(User[] userList) {
		this.userList = userList;
	}

	public void executeTransaction(String name, String fromCurrency, String toCurrency, double amountOfTransaction,
			double convertedAmount) {
		
		if (fromCurrency.equals(toCurrency)) {
			logger.info("SKIP: Same Currency, no transaction is needed ");
		} else {
			for (User user : userList) {
				
				if (user.getName().equals(name)) {
					
					currentUser = user;

					if (currentUser.getWallet().get(fromCurrency) < amountOfTransaction
							|| !(currentUser.getWallet().containsKey(fromCurrency))) {
						logger.info("SKIP: " + name + "'s " + fromCurrency + " account balance is less than "
								+ amountOfTransaction);
					} else {
						currentUser.getWallet().put(fromCurrency,
								currentUser.getWallet().get(fromCurrency) - amountOfTransaction);
						if (!(currentUser.getWallet().containsKey(toCurrency))) {
							currentUser.getWallet().put(toCurrency, convertedAmount);
						} else {
							currentUser.getWallet().put(toCurrency,
									currentUser.getWallet().get(toCurrency) + convertedAmount);
						}

						logger.info("Sucess transaction: " + name + " has convert " + amountOfTransaction + " "
								+ fromCurrency + " to " + convertedAmount + " " + toCurrency);
						

					}
				}
				
				
			
			}

		
		}
		
	}

	public void updateUserFile(String UserFile) throws StreamWriteException, DatabindException, IOException {
		UserListHandler.write(userList, UserFile);

	}

}
