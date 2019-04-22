package com.src.UI;

import java.util.List;
import java.util.Scanner;

import com.src.bean.Registration;
import com.src.exception.AadharException;
import com.src.exception.EmailException;
import com.src.exception.MobileException;
import com.src.exception.PanException;
import com.src.exception.PasswordValidation;
import com.src.exception.Validation;
import com.src.service.EntryServiceImpl;
import com.src.service.IEntry;
import com.src.service.ITransaction;
import com.src.service.TransactionServiceImpl;

public class MainUI {
	Scanner scan;
	static Registration registration;
	Validation valid;
	MainUI mainui;

	public static void main(String[] args) throws Exception {
		MainUI mainui = new MainUI();
		mainui.choice();
	}

	public Registration register() throws Exception {
		scan = new Scanner(System.in);

		registration = new Registration();

		valid = new Validation();

		System.out.println("enter firstName");
		String firstName = scan.next();
		registration.setFirstName(firstName);

		System.out.println("enter lastName");
		String lastName = scan.next();
		registration.setLastName(lastName);

		System.out.println("enter password");
		String password = scan.next();
		boolean isPasswordValid = valid.password(password);
		if (isPasswordValid) {
			registration.setPassword(password);
		} else {
			throw new PasswordValidation("Invalid password");
		}

		System.out.println("enter email");
		String emailId = scan.next();
		boolean isEmailValid = valid.emailValidate(emailId);
		if (isEmailValid) {
			registration.setEmailId(emailId);
		} else {
			throw new EmailException("Invaled email");
		}

		System.out.println("enter panCard");
		String panCard = scan.next();
		boolean isPanValid = valid.panValidate(panCard);
		if (isPanValid) {
			registration.setPanCard(panCard);
		} else {
			throw new PanException("Invalid Pan");
		}

		System.out.println("enter aadharNumber");
		long aadharNumber = scan.nextLong();
		boolean isAadharValid = valid.aadharValidate(aadharNumber);
		if (isAadharValid) {
			registration.setAadharNo(aadharNumber);
		} else {
			throw new AadharException("Aadhar invalid");
		}

		System.out.println("enter address");
		String address = scan.next();
		registration.setAddress(address);

		System.out.println("enter mobileNumber");
		long mobileNumber = scan.nextLong();
		boolean isMobileValid = valid.mobileValidate(mobileNumber);
		registration.setMobileNo(mobileNumber);

		System.out.println("enter balance");
		Integer balance = scan.nextInt();
		registration.setBalance(balance);

		return registration;

	}

	public void choice() throws Exception {
		Scanner in = new Scanner(System.in);
		MainUI mainui = new MainUI();
		IEntry entry = new EntryServiceImpl();

		System.out.println("please enter your choice \n1.Registration \n2.Login \n3.Exit");
		int choice = in.nextInt();
		while (choice <= 3) {
			switch (choice) {
			case 1:
				registration = mainui.register();
				entry.register(registration);
				break;
			case 2:
				System.out.println("please enter your account number");
				long accNumber = in.nextInt();
				System.out.println("please enter your password");
				String password = in.next();

				entry.login(accNumber, password);
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("please enter correct choice");

			}
			System.out.println("please enter your choice \n1.Registration \n2.Login \n3.Exit");
			choice = in.nextInt();
		}

	}

	public void printAccountNo(int no) {
		System.out.println("account number is " + no);
	}

	public void showTransaction(List<Registration> list, long accountNo) throws Exception {

		ITransaction trans = new TransactionServiceImpl();
		Scanner in = new Scanner(System.in);

		System.out.println("please select your transaction");
		System.out.println("\n1.Deposit \n2.Withdrawl \n3.ViewBalance \n4.FundTransafer \n5.Exit");

		int transactionChoice = in.nextInt();

		while (transactionChoice <= 5) {
			switch (transactionChoice) {
			case 1:
				System.out.println("please enter amount");
				float amount = in.nextFloat();
				trans.deposit(list, accountNo, amount);
				break;
			case 2:
				System.out.println("please enter amount");
				amount = in.nextFloat();
				trans.withdraw(list, accountNo, amount);
				break;
			case 3:
				trans.viewBalance(list, accountNo);
				break;
			case 4:
				System.out.println("please enter amount");
				amount = in.nextFloat();

				System.out.println("please enter account number you wish to transfer");
				long toAccount = in.nextLong();

				trans.fundTransfer(list, accountNo, toAccount, amount);
				break;
			case 5:
				System.out.println("Thank you ...please visit agian....");
				// mainui.choice();
				// choice();
				System.exit(0);
			}

			System.out.println("please select your transaction");
			System.out.println("\n1.Deposit \n2.Withdrawl \n3.ViewBalance \n4.FundTransafer \n5.Exit");

			transactionChoice = in.nextInt();
		}
	}

	public void printBalance(int amount) {
		System.out.println("the balance is " + amount);
	}

	public void printWarning() {
		System.out.println("You have no enough balance....please deposit to withdraw the amount..");
	}

	public void printError() {
		System.out.println("Sorry...invalid credentuials...try again...");
	}

	public void accountWarning() {
		System.out.println("Please create the account...");
	}

	public void mobileStatus() {
		// TODO Auto-generated method stub
		System.out.println("Invalid mobile number");
	}

	public void adharStatus() {
		// TODO Auto-generated method stub
		System.out.println("Invalid adhar number");
	}

	public void updateStatus() {
		System.out.println("Transaction successful");
	}
	
	public void tranferInvalidate() {
		System.out.println("sorry....u can not transfer amount from your accuount to your own account");
		
	}

}
