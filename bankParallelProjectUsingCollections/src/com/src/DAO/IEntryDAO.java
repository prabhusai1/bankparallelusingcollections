package com.src.DAO;

import com.src.bean.Registration;

public interface IEntryDAO {

	public int register(Registration registration);

	public void login(long accoutNo, String password) throws Exception;
}
