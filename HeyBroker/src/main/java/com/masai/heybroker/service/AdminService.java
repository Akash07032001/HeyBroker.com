package com.masai.heybroker.service;

import com.masai.heybroker.exception.AdminException;
import com.masai.heybroker.model.Admin;

public interface AdminService {
    public Admin createAdmin(Admin admin)throws AdminException;

    public Admin updateAdmin(Admin admin, String key) throws AdminException;
}
