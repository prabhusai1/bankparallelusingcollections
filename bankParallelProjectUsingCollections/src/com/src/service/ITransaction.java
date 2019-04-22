package com.src.service;

import java.util.List;

import com.src.bean.Registration;

public interface ITransaction {

	public int deposit(List<Registration> list, long accountNo, float amount);

	public int withdraw(List<Registration> list, long accountNo, float amount);

	public int viewBalance(List<Registration> list, long accountNo);

	public int fundTransfer(List<Registration> list, long fromAccountNo, long toAccountNo, float amount);

}
