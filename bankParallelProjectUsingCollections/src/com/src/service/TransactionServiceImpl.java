package com.src.service;

import java.util.List;

import com.src.DAO.ITransactionDAO;
import com.src.DAO.TransactionDAOImpl;
import com.src.UI.MainUI;
import com.src.bean.Registration;

public class TransactionServiceImpl implements ITransaction {

	ITransactionDAO transact=new TransactionDAOImpl();

	@Override
	public int deposit(List<Registration> list, long accountNo, float amount) {
		// TODO Auto-generated method stub
		transact.deposit(list, accountNo, amount);
		return 1;
	}

	@Override
	public int withdraw(List<Registration> list, long accountNo, float amount) {
		// TODO Auto-generated method stub
		transact.withdraw(list, accountNo, amount);
		return 1;
		
	}

	@Override
	public int viewBalance(List<Registration> list, long accountNo) {
		// TODO Auto-generated method stub
		transact.viewBalance(list, accountNo);
		return 0;
	}

	@Override
	public int fundTransfer(List<Registration> list, long fromAccountNo, long toAccountNo, float amount) {
		// TODO Auto-generated method stub
		transact.fundTransfer(list, fromAccountNo, toAccountNo, amount);
		return 0;
	}

}
