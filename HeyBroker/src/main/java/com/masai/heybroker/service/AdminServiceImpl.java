package com.masai.heybroker.service;

import com.masai.heybroker.exception.AdminException;
import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.AdminCurrentSesssion;
import com.masai.heybroker.repository.AdminDao;
import com.masai.heybroker.repository.AdminSessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminSessionDao adminSessionDao;
    @Override
    public Admin createAdmin(Admin admin) throws AdminException {
        Admin existingAdmin = adminDao.findByEmail(admin.getEmail());

        if(existingAdmin!=null) throw new AdminException("Admin already registered with email "+admin.getEmail());

        return adminDao.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin, String key) throws AdminException {

        AdminCurrentSesssion logeedInUser = adminSessionDao.findByAid(key);

        if(logeedInUser==null) throw new AdminException("Please provide valid key to update admin");

        if(admin.getAdminId()==logeedInUser.getAdminId()){

            return adminDao.save(admin);
        }else throw new AdminException("Invalid admin details please log in first");
    }
}
