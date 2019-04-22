package com.src.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.src.UI.MainUI;
import com.src.bean.Registration;

public class EntryDAOImpl implements IEntryDAO {

	ArrayList<Registration> registeredList = new ArrayList<Registration>();
	Registration registration;
	MainUI mainui = new MainUI();
	Random random;

	public int register(Registration registration) {

		random = new Random();

		// Generating random number for account number
		registration.setAccountNo(random.nextInt(99999999));

		long accountNo = registration.getAccountNo();
		String firstName = registration.getFirstName();
		String lastName = registration.getLastName();
		String emailId = registration.getEmailId();
		String password = registration.getPassword();
		String panCard = registration.getPanCard();
		long aadharNo = registration.getAadharNo();
		String address = registration.getAddress();
		long mobileNo = registration.getMobileNo();
		float balance = registration.getBalance();

		// Adding Registration object to array list of type Registration
		registeredList.add(new Registration(accountNo, firstName, lastName, emailId, password, panCard, aadharNo,
				address, mobileNo, balance));

		int account = (int) registration.getAccountNo();

		mainui.printAccountNo(account);
		return (int) registration.getAccountNo();
	}

	public void login(long accoutNo, String password) throws Exception {

		int count = 0;
		for (Registration registration : registeredList) {
			if ((registration.getAccountNo() == accoutNo) && (registration.getPassword().equals(password))) {
				mainui.showTransaction(registeredList, accoutNo);
				count++;
				break;
			}
		}

		if (count == 0) {
			mainui.printError();
		}
	}
}
