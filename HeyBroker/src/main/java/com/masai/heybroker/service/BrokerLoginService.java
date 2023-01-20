package com.masai.heybroker.service;

import com.masai.heybroker.exception.LoginException;
import com.masai.heybroker.model.AdminLoginDTO;
import com.masai.heybroker.model.BrokerLoginDTO;

public interface BrokerLoginService {

    public String logIntoAccount(BrokerLoginDTO brokerLoginDTO)throws LoginException;

    public String logOutFromAccount(String key)throws LoginException;
}
