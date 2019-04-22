package com.src.DAO;

import java.util.List;

import com.src.bean.Registration;

public interface ITransactionDAO {
	public int deposit(List<Registration> list, long accountNo, float amount);

	public int withdraw(List<Registration> list, long accountNo, float amount);

	public int viewBalance(List<Registration> list, long accountNo);

	public int fundTransfer(List<Registration> list, long fromAccountNo, long toAccountNo, float amount);
}
