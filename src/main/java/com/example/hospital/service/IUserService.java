package com.example.hospital.service;

import com.example.hospital.entity.Account;
import com.example.hospital.entity.Role;

public interface IUserService {

    Account GetAccountByName(String name);
    Account SaveAccount(Account account);

    Role AddRole(Role role);


}
