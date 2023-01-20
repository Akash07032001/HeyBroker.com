package com.masai.heybroker.service;

import com.masai.heybroker.exception.LoginException;
import com.masai.heybroker.model.AdminLoginDTO;
import com.masai.heybroker.model.CustomerLoginDTO;

public interface CustomerLoginService {

    public String logIntoAccount(CustomerLoginDTO customerLoginDTO)throws LoginException;

    public String logOutFromAccount(String key)throws LoginException;
}
