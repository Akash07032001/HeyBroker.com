package com.masai.heybroker.service;

import com.masai.heybroker.exception.LoginException;
import com.masai.heybroker.model.AdminLoginDTO;

public interface AdminLoginService {

    public String logIntoAccount(AdminLoginDTO adminLoginDTO)throws LoginException;

    public String logOutFromAccount(String key)throws LoginException;
}
