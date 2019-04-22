package com.src.service;

import com.src.DAO.EntryDAOImpl;
import com.src.DAO.IEntryDAO;
import com.src.bean.Registration;

public class EntryServiceImpl implements IEntry{

	IEntryDAO entry=new EntryDAOImpl();
	@Override
	public int register(Registration registration) {
		entry.register(registration);
		return 0;
	}

	@Override
	public void login(long accoutNo, String password) throws Exception {
		entry.login(accoutNo, password);
		
	}

}
