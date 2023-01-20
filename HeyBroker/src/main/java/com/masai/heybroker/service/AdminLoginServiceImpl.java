package com.masai.heybroker.service;

import com.masai.heybroker.exception.LoginException;
import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.AdminCurrentSesssion;
import com.masai.heybroker.model.AdminLoginDTO;
import com.masai.heybroker.repository.AdminDao;
import com.masai.heybroker.repository.AdminSessionDao;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminSessionDao adminSessionDao;


    @Override
    public String logIntoAccount(AdminLoginDTO adminLoginDTO) throws LoginException {
        Admin existingAdmin = adminDao.findByEmail(adminLoginDTO.getEmail());

        if(existingAdmin==null) throw new LoginException("Please enter valid email");

        Optional<AdminCurrentSesssion> opt = adminSessionDao.findById(existingAdmin.getAdminId());

        if(opt.isPresent()) throw new LoginException("User already logged in with this email");

        if(existingAdmin.getPassword().equals(adminLoginDTO.getPassword())){
            String key = RandomString.make(6);

            AdminCurrentSesssion adminCurrentSesssion = new AdminCurrentSesssion(existingAdmin.getAdminId(),key, LocalDateTime.now());

            adminSessionDao.save(adminCurrentSesssion);
            return adminCurrentSesssion.getAid();
        }else {
            throw new LoginException("Please Enter a valid password");
        }
    }

    @Override
    public String logOutFromAccount(String key) throws LoginException {

        AdminCurrentSesssion adminCurrentSesssion = adminSessionDao.findByAid(key);

        if(adminCurrentSesssion==null) throw new LoginException("Admin not logged in with this email");

        adminSessionDao.delete(adminCurrentSesssion);

        return "Logged out successfully!";
    }
}
