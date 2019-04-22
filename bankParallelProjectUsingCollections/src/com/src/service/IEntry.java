package com.src.service;

import com.src.bean.Registration;

public interface IEntry {

	public int register(Registration registeration);

	public void login(long accoutNo, String password) throws Exception;
}
