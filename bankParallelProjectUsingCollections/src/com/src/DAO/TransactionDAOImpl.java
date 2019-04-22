package com.src.DAO;

import java.util.List;

import com.src.UI.MainUI;
import com.src.bean.Registration;

public class TransactionDAOImpl implements ITransactionDAO {

	MainUI mainui;

	@Override
	public int deposit(List<Registration> list, long accountNo, float amount) {
		mainui = new MainUI();
		float balance = 0;
		for (Registration r : list) {
			if (r.getAccountNo() == accountNo) {
				float bal = r.getBalance();
				r.setBalance(bal + amount);
				balance = r.getBalance();
				break;
			}
		}

		mainui.printBalance((int) balance);

		return 1;
	}

	@Override
	public int withdraw(List<Registration> list, long accountNo, float amount) {
		// TODO Auto-generated method stub

		mainui = new MainUI();
		float balance = 0;

		for (Registration r : list) {
			if (r.getAccountNo() == accountNo) {
				float bal = r.getBalance();
				// checking if balance is sufficient or not
				if (bal > amount) {
					r.setBalance(bal - amount);
					balance = r.getBalance();
					break;
				} else {
					mainui.printWarning();
				}
			}
		}

		mainui.printBalance((int) balance);
		return 1;
	}

	@Override
	public int viewBalance(List<Registration> list, long accountNo) {
		// TODO Auto-generated method stub
		float bal;
		for (Registration r : list) {
			if (r.getAccountNo() == accountNo) {
				bal = r.getBalance();
				mainui.printBalance((int) bal);
			}
		}
		return 1;
	}

	@Override
	public int fundTransfer(List<Registration> list, long fromAccountNo, long toAccountNo, float amount) {
		// TODO Auto-generated method stub
		if(fromAccountNo==toAccountNo) {
			mainui.tranferInvalidate();
			return 0;
		}
		
		mainui = new MainUI();
		int count = 0;
		float balance = 0;
		for (Registration r : list) {
			if (r.getAccountNo() == toAccountNo) {
				float bal = r.getBalance();
				r.setBalance(bal + amount);
				balance = r.getBalance();
				count++;
				break;
			}
		}

		if (count != 0) {
			for (Registration r : list) {
				if (r.getAccountNo() == fromAccountNo) {
					float bal = r.getBalance();
					r.setBalance(bal - amount);
					balance = r.getBalance();
					break;
				}
			}
		} else {
			mainui.accountWarning();
		}
		mainui.printBalance((int) balance);

		return 1;
	}

}
