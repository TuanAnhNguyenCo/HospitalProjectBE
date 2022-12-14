package com.example.hospital.reponsitory;

import com.example.hospital.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Integer> {
    Account findAccountByUsername(String name);
}
